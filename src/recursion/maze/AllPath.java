package recursion.maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPath {
    public static void main(String[] args) {
        boolean[][] maze = new boolean[][] {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        boolean[][] vis = new boolean[][] {
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };
        System.out.println(allPath(maze, vis, 0, 0, ""));

        int[][] visMatrix = new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        allPathPrint(maze, visMatrix, 0, 0, "", 1);

    }

    private static List<String> allPath(boolean[][] maze, boolean[][] vis, int row, int col, String path) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            List<String> res = new ArrayList<>();
            res.add(path);
            return res;
        }

        if (!maze[row][col]) {
            return new ArrayList<>();
        }

        if (vis[row][col]) {
            return new ArrayList<>();
        }

        vis[row][col] = true;

        List<String> res = new ArrayList<>();

        // going down
        if (row < maze.length - 1) {
            res.addAll(allPath(maze, vis, row + 1, col, path + 'D'));
        }

        // going right
        if (col < maze[0].length - 1) {
            res.addAll(allPath(maze, vis, row, col + 1, path + 'R'));
        }

        // going top
        if (row > 0) {
            res.addAll(allPath(maze, vis, row - 1, col, path + 'U'));
        }

        // going left
        if (col > 0) {
            res.addAll(allPath(maze, vis, row, col - 1, path + 'L'));
        }

        vis[row][col] = false;

        return res;
    }

    private static void allPathPrint(boolean[][] maze, int[][] vis, int row, int col, String path, int count) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            vis[row][col] = count;
            for (int[] mat : vis) {
                System.out.println(Arrays.toString(mat));
            }
            System.out.println(path);
            System.out.println();
            vis[row][col] = 0;
            return;
        }

        if (!maze[row][col]) {
            return;
        }

        if (vis[row][col] != 0) {
            return;
        }

        vis[row][col] = count;

        List<String> res = new ArrayList<>();

        // going down
        if (row < maze.length - 1) {
            allPathPrint(maze, vis, row + 1, col, path + 'D', count + 1);
        }

        // going right
        if (col < maze[0].length - 1) {
            allPathPrint(maze, vis, row, col + 1, path + 'R', count + 1);
        }

        // going top
        if (row > 0) {
            allPathPrint(maze, vis, row - 1, col, path + 'U', count + 1);
        }

        // going left
        if (col > 0) {
            allPathPrint(maze, vis, row, col - 1, path + 'L', count + 1);
        }

        vis[row][col] = 0;
    }

}
