package Problem201_300;

/**
 * Created by mwindson on 2017/3/8.
 */

import java.text.MessageFormat;
import java.util.*;

/**
 * Leetcode compatible Util.TreeNode class implementation with parse&stringify functionality.
 * todo tokenizer目前是瞎写的, 可以满足正确的输入. parse中的状态机报错比较简单.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 从字符串中解析二叉树
     *
     * @param string 输入字符串
     * @return 解析得到的二叉树
     */
    public static TreeNode parse(String string) {
        char[] word = string.toCharArray();
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode currentParent = null;
        TreeNode root = null;
        MachineState currentState = MachineState.INIT;

        int index = 0;
        while (index < string.length()) {
            Token token = getToken(word, index);
            index += token.length;

            if (token.type == TokenType.EMPTY) {
                continue;
            }

            boolean parseError = false;
            if (currentState == MachineState.INIT) {
                if (token.type == TokenType.OPEN) {
                    currentState = MachineState.WAIT_NUMBER;
                    debug(token, MachineState.INIT, MachineState.WAIT_NUMBER);
                } else {
                    parseError = true;
                }
            } else if (currentState == MachineState.WAIT_NUMBER) {
                if (token.type == TokenType.NUMBER) {
                    if (queue.isEmpty() && currentParent == null) {
                        root = new TreeNode(token.value);
                        queue.add(root);
                    } else {
                        if (currentParent == null) {
                            currentParent = queue.poll();
                            TreeNode node = new TreeNode(token.value);
                            currentParent.left = node;
                            queue.add(node);
                        } else {
                            TreeNode node = new TreeNode(token.value);
                            currentParent.right = node;
                            queue.add(node);
                            currentParent = null;
                        }
                    }
                    currentState = MachineState.WAIT_CLOSE;
                    debug(token, MachineState.WAIT_NUMBER, MachineState.WAIT_CLOSE);
                } else if (token.type == TokenType.NULL) {
                    if (queue.isEmpty() && currentParent == null) {
                        throw new ParseException("Error: this null is invalid.");
                    } else {
                        if (currentParent == null) {
                            currentParent = queue.remove();
                        } else {
                            currentParent = null;
                        }
                    }
                    currentState = MachineState.WAIT_CLOSE;
                    debug(token, MachineState.WAIT_NUMBER, MachineState.WAIT_CLOSE);
                } else {
                    parseError = true;
                }
            } else if (currentState == MachineState.WAIT_CLOSE) {
                if (token.type == TokenType.DELIMITER) {
                    currentState = MachineState.WAIT_NUMBER;
                    debug(token, MachineState.WAIT_CLOSE, MachineState.WAIT_NUMBER);
                } else if (token.type == TokenType.CLOSE) {
                    currentState = MachineState.ACCEPTED;
                    debug(token, MachineState.WAIT_CLOSE, MachineState.ACCEPTED);
                } else {
                    parseError = true;
                }
            } else { // ACCEPTED or other
                parseError = true;
            }
            if (parseError) {
                throw new ParseException("Invalid token: " + token);
            }
        }
        return root;
    }

    /**
     * 将二叉树序列化为字符串. (使用leetcode的格式)
     *
     * @param root 二叉树根节点
     * @return 序列化之后的字符串
     */
    public static String stringify(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        list.add(String.valueOf(root.val));
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left == null) {
                list.add("null");
            } else {
                list.add(String.valueOf(node.left.val));
                queue.add(node.left);
            }
            if (node.right == null) {
                list.add("null");
            } else {
                list.add(String.valueOf(node.right.val));
                queue.add(node.right);
            }
        }
        while (list.get(list.size() - 1).equals("null")) {
            list.remove(list.size() - 1);
        }
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        list.forEach(joiner::add);
        return joiner.toString();
    }

    private static void debug(Token token, MachineState oldState, MachineState newState) {
//        System.out.println(MessageFormat.format("{0}: {1} -> {2}", token, oldState, newState));
    }

    private static Token getToken(char[] word, int start) {
        int end = start;
        while (end < word.length && (word[end] == ' ' || word[end] == '\t' || word[end] == '\n')) {
            end++;
        }
        if (end == word.length) {
            return new Token(TokenType.EMPTY, end - start);
        } else if (word[end] == '[') {
            end++;
            return new Token(TokenType.OPEN, end - start);
        } else if (word[end] == ']') {
            end++;
            return new Token(TokenType.CLOSE, end - start);
        } else if (word[end] == ',') {
            end++;
            return new Token(TokenType.DELIMITER, end - start);
        } else if (word[end] == '-' || word[end] >= '0' && word[end] <= '9') {
            boolean minus = word[end] == '-';
            if (minus) {
                end++;
            }
            int value = 0;
            while (end < word.length && word[end] >= '0' && word[end] <= '9') {
                value = value * 10 + (word[end] - '0');
                end++;
            }
            return new Token(TokenType.NUMBER, minus ? -value : value, end - start);
        } else if (test(word, end, "null")) {
            end += "null".length();
            return new Token(TokenType.NULL, end - start);
        } else {
            throw new ParseException(MessageFormat.format("Unknown token - {0}", word[end]));
        }
    }

    private static boolean test(char[] word, int start, String target) {
        if (start >= 0 && start < word.length && start + target.length() < word.length) {
            for (int t = 0; t < target.length(); t++) {
                if (word[start + t] != target.charAt(t)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class ParseException extends RuntimeException {
        public ParseException(String message) {
            super(message);
        }
    }

    private enum TokenType {
        EMPTY, OPEN, CLOSE, DELIMITER, NUMBER, NULL
    }

    private enum MachineState {
        INIT, WAIT_NUMBER, WAIT_CLOSE, ACCEPTED
    }

    private static class Token {
        TokenType type;
        int value;
        int length;

        public Token(TokenType type, int value, int length) {
            this.type = type;
            this.value = value;
            this.length = length;
        }

        public Token(TokenType type, int length) {
            this.type = type;
            this.length = length;
        }

        public String toString() {
            if (type == TokenType.EMPTY || type == TokenType.OPEN || type == TokenType.CLOSE || type == TokenType.NULL || type == TokenType.DELIMITER) {
                return MessageFormat.format("Token'{'type={0}'}'", type);
            }
            return MessageFormat.format("Token'{'type={0}, value={1}, length={2}'}'", type, value, length);
        }
    }
}

