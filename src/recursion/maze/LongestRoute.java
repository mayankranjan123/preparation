package recursion.maze;

public class LongestRoute {
    public static void main(String[] args) {
        int mat[][] = { { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 } };

        boolean [][] vis = new boolean[mat.length][mat[0].length];

        System.out.println(longest(mat, 0, 0, 2, 3, vis) - 1);
    }

    private static int longest(int[][] mat, int startRow, int startCol, int endRow, int endCol, boolean[][] vis) {
        if (startRow == endRow && startCol == endCol) {
            return 1;
        }

        if (mat[startRow][startCol] == 0) {
            return 0;
        }

        if (vis[startRow][startCol]) {
            return 0;
        }

        vis[startRow][startCol] = true;

        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        if (startRow > 0) {
            up = 1 + longest(mat, startRow - 1, startCol, endRow, endCol, vis);
        }

        if (startCol > 0) {
            left = 1 + longest(mat, startRow, startCol - 1, endRow, endCol, vis);
        }

        if (startRow < mat.length - 1) {
            down = 1 + longest(mat, startRow + 1, startCol, endRow, endCol, vis);
        }

        if (startCol < mat[0].length - 1) {
            right = 1 + longest(mat, startRow, startCol + 1, endRow, endCol, vis);
        }

        vis[startRow][startCol] = false;

        return Math.max(up, Math.max(down, Math.max(left, right)));
    }


}
