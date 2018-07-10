package nowcoder;

public class P65 {
    public static void main(String[] args) {
        char[] matrix = {'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};
        System.out.println(new P65().hasPath(matrix, 3, 4, new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'}));
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] m = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m[i][j] = matrix[index];
                index++;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (m[i][j] == str[0]) {
                    boolean[][] visited = new boolean[rows][cols];
                    if (canFind(m, visited, i, j, str, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean canFind(char[][] matrix, boolean[][] visited, int i, int j, char[] str, int index) {
        if (matrix[i][j] != str[index]) return false;
        if (index == str.length - 1) return true;
        visited[i][j] = true;
        int[][] ds = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : ds) {
            int nextI = i + d[0];
            int nextJ = j + d[1];
            if (nextI < 0 || nextJ < 0 || nextI >= matrix.length || nextJ >= matrix[0].length || visited[nextI][nextJ])
                continue;
            if (canFind(matrix, visited, nextI, nextJ, str, index + 1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
