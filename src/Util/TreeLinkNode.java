package Util;

import java.text.MessageFormat;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by mwindson on 2017/3/11.
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;

    public TreeLinkNode(int x) {
        val = x;
    }

    public static TreeLinkNode parse(String string) {
        char[] word = string.toCharArray();
        Queue<TreeLinkNode> queue = new ArrayDeque<>();
        TreeLinkNode currentParent = null;
        TreeLinkNode root = null;
        TreeLinkNode.MachineState currentState = TreeLinkNode.MachineState.INIT;

        int index = 0;
        while (index < string.length()) {
            TreeLinkNode.Token token = getToken(word, index);
            index += token.length;

            if (token.type == TreeLinkNode.TokenType.EMPTY) {
                continue;
            }

            boolean parseError = false;
            if (currentState == TreeLinkNode.MachineState.INIT) {
                if (token.type == TreeLinkNode.TokenType.OPEN) {
                    currentState = TreeLinkNode.MachineState.WAIT_NUMBER;
                    debug(token, TreeLinkNode.MachineState.INIT, TreeLinkNode.MachineState.WAIT_NUMBER);
                } else {
                    parseError = true;
                }
            } else if (currentState == TreeLinkNode.MachineState.WAIT_NUMBER) {
                if (token.type == TreeLinkNode.TokenType.NUMBER) {
                    if (queue.isEmpty() && currentParent == null) {
                        root = new TreeLinkNode(token.value);
                        queue.add(root);
                    } else {
                        if (currentParent == null) {
                            currentParent = queue.poll();
                            TreeLinkNode node = new TreeLinkNode(token.value);
                            currentParent.left = node;
                            queue.add(node);
                        } else {
                            TreeLinkNode node = new TreeLinkNode(token.value);
                            currentParent.right = node;
                            queue.add(node);
                            currentParent = null;
                        }
                    }
                    currentState = TreeLinkNode.MachineState.WAIT_CLOSE;
                    debug(token, TreeLinkNode.MachineState.WAIT_NUMBER, TreeLinkNode.MachineState.WAIT_CLOSE);
                } else if (token.type == TreeLinkNode.TokenType.NULL) {
                    if (queue.isEmpty() && currentParent == null) {
                        throw new TreeLinkNode.ParseException("Error: this null is invalid.");
                    } else {
                        if (currentParent == null) {
                            currentParent = queue.remove();
                        } else {
                            currentParent = null;
                        }
                    }
                    currentState = TreeLinkNode.MachineState.WAIT_CLOSE;
                    debug(token, TreeLinkNode.MachineState.WAIT_NUMBER, TreeLinkNode.MachineState.WAIT_CLOSE);
                } else {
                    parseError = true;
                }
            } else if (currentState == TreeLinkNode.MachineState.WAIT_CLOSE) {
                if (token.type == TreeLinkNode.TokenType.DELIMITER) {
                    currentState = TreeLinkNode.MachineState.WAIT_NUMBER;
                    debug(token, TreeLinkNode.MachineState.WAIT_CLOSE, TreeLinkNode.MachineState.WAIT_NUMBER);
                } else if (token.type == TreeLinkNode.TokenType.CLOSE) {
                    currentState = TreeLinkNode.MachineState.ACCEPTED;
                    debug(token, TreeLinkNode.MachineState.WAIT_CLOSE, TreeLinkNode.MachineState.ACCEPTED);
                } else {
                    parseError = true;
                }
            } else { // ACCEPTED or other
                parseError = true;
            }
            if (parseError) {
                throw new TreeLinkNode.ParseException("Invalid token: " + token);
            }
        }
        return root;
    }

    private static void debug(TreeLinkNode.Token token, TreeLinkNode.MachineState oldState, TreeLinkNode.MachineState newState) {
//        System.out.println(MessageFormat.format("{0}: {1} -> {2}", token, oldState, newState));
    }

    private static TreeLinkNode.Token getToken(char[] word, int start) {
        int end = start;
        while (end < word.length && (word[end] == ' ' || word[end] == '\t' || word[end] == '\n')) {
            end++;
        }
        if (end == word.length) {
            return new TreeLinkNode.Token(TreeLinkNode.TokenType.EMPTY, end - start);
        } else if (word[end] == '[') {
            end++;
            return new TreeLinkNode.Token(TreeLinkNode.TokenType.OPEN, end - start);
        } else if (word[end] == ']') {
            end++;
            return new TreeLinkNode.Token(TreeLinkNode.TokenType.CLOSE, end - start);
        } else if (word[end] == ',') {
            end++;
            return new TreeLinkNode.Token(TreeLinkNode.TokenType.DELIMITER, end - start);
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
            return new TreeLinkNode.Token(TreeLinkNode.TokenType.NUMBER, minus ? -value : value, end - start);
        } else if (test(word, end, "null")) {
            end += "null".length();
            return new TreeLinkNode.Token(TreeLinkNode.TokenType.NULL, end - start);
        } else {
            throw new TreeLinkNode.ParseException(MessageFormat.format("Unknown token - {0}", word[end]));
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
        TreeLinkNode.TokenType type;
        int value;
        int length;

        public Token(TreeLinkNode.TokenType type, int value, int length) {
            this.type = type;
            this.value = value;
            this.length = length;
        }

        public Token(TreeLinkNode.TokenType type, int length) {
            this.type = type;
            this.length = length;
        }

        public String toString() {
            if (type == TreeLinkNode.TokenType.EMPTY || type == TreeLinkNode.TokenType.OPEN || type == TreeLinkNode.TokenType.CLOSE || type == TreeLinkNode.TokenType.NULL || type == TreeLinkNode.TokenType.DELIMITER) {
                return MessageFormat.format("Token'{'type={0}'}'", type);
            }
            return MessageFormat.format("Token'{'type={0}, value={1}, length={2}'}'", type, value, length);
        }
    }
}
