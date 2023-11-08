package recursion.maze;

public class UniquePaths3 {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,2,-1}
        };
        System.out.println(new UniquePaths3().uniquePathsIII(grid));
    }

    public int uniquePathsIII(int[][] grid) {
        boolean [][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return solve(grid, vis, i, j);
                }
            }
        }
        return 0;
    }

    int solve(int[][] grid, boolean[][] vis, int row, int col) {
        if (row == grid.length || col == grid[0].length || row < 0 || col <0) {
            return 0;
        }

        if (grid[row][col] == 2) {
            if (isOnce(grid, vis)) {
                return 1;
            }
            return 0;
        }

        if (vis[row][col] || grid[row][col] == -1) {
            return 0;
        }

        vis[row][col] = true;
        int ans = 0;

        if (row < grid.length - 1) {
            ans += solve(grid, vis, row + 1, col);
        }

        if (col < grid[0].length - 1) {
            ans += solve(grid, vis, row, col + 1);
        }

        if (row > 0) {
            ans += solve(grid, vis, row - 1, col);
        }

        if (col > 0) {
            ans += solve(grid, vis, row, col - 1);
        }

        return ans;
    }

    boolean isOnce(int[][] grid, boolean[][] vis) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !vis[i][j]) {
                    return false;
                }
            }
        }
        return true;


    }
}
