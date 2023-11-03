package recursion.maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
        System.out.println(maze(3, 3));
        System.out.println(mazePath(3, 3, ""));

        boolean[][] maze = new boolean[][] {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };

        System.out.println(pathRestrictions(maze, 0, 0, ""));
    }

    private static List<String> pathRestrictions(boolean[][] maze, int row, int col, String path) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            List<String> res = new ArrayList<>();
            res.add(path);
            return res;
        }

        if (!maze[row][col]) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();

        if (row < maze.length - 1) {
            res.addAll(pathRestrictions(maze, row + 1, col, path + 'D'));
        }

        if (col < maze[0].length - 1) {
            res.addAll(pathRestrictions(maze, row, col + 1, path + 'R'));
        }

        return res;
    }

    private static ArrayList<String> mazePath(int row, int col, String path) {
        if (row == 1 && col == 1) {
            ArrayList<String> res = new ArrayList<>();
            res.add(path);
            return res;
        }

        ArrayList<String> res = new ArrayList<>();
        if (row > 1) {
            res.addAll(mazePath(row - 1, col, path + 'D'));
        }

        if (col > 1) {
            res.addAll(mazePath(row, col - 1, path + 'R'));
        }

        return res;
    }

    private static int maze(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }

        int count = 0;
        if (row > 1) {
            count += maze(row - 1, col);
        }

        if (col > 1) {
            count += maze(row, col - 1);
        }

        return count;
    }
}
