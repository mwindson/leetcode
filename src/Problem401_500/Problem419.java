package Problem401_500;

/**
 * Created by mwindson on 2017/5/21.
 * https://leetcode.com/problems/battleships-in-a-board/#/description
 */
public class Problem419 {
    public static void main(String[] args) {
        char[][] board = {
                {'X', '.', '.', 'X'},
                {'.', 'X', '.', 'X'},
                {'X', '.', '.', 'X'},
        };
        System.out.println(countBattleships(board));
    }

    public static int countBattleships(char[][] board) {
        if (board.length == 0) return 0;
        int count = 0;
        int[][] ships = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (i == 0 && j == 0) {
                        ships[i][j] = 1;
                    }
                    if (i == 0 && j > 0) {
                        ships[i][j] = board[i][j - 1] != '.' ? ships[i][j - 1] : count + 1;
                    }
                    if (i > 0 && j == 0) {
                        ships[i][j] = board[i - 1][j] != '.' ? ships[i - 1][j] : count + 1;
                    }
                    if (i > 0 && j > 0) {
                        if (board[i - 1][j] != '.') {
                            ships[i][j] = ships[i - 1][j];
                        } else if (board[i][j - 1] != '.') {
                            ships[i][j] = ships[i][j - 1];
                        } else {
                            ships[i][j] = count + 1;
                        }
                    }
                    count = Math.max(ships[i][j], count);
                }
            }
        }
        return count;
    }
}
