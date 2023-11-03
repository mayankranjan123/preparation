package recursion.maze;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        System.out.println(queen(4));
    }

    private static List<List<String>> queen(int n) {
        boolean[][] queen = new boolean[n][n];
        return solve(queen, 0);
    }

    private static List<List<String>> solve(boolean[][] queen, int row) {
        if (row == queen.length) {
            List<List<String>> res = new ArrayList<>();
            for (boolean[] q : queen) {
                List<String> rowWise = new ArrayList<>();
                for (boolean el : q) {
                    if (el) {
                        rowWise.add("Q");
                    } else {
                        rowWise.add(".");
                    }
                }
                res.add(rowWise);
            }
            return res;
        }

        List<List<String>> res = new ArrayList<>();
        for (int col = 0; col < queen[0].length; col ++) {
            if (isSafe(queen, row, col)) {
                queen[row][col] = true;
                res.addAll(solve(queen, row + 1));
                queen[row][col] = false;
            }
        }
        return res;
    }

    private static boolean isSafe(boolean[][] queen, int row, int col) {
        // check vertically
        for (int i = 0; i < row; i++) {
            if (queen[i][col]) {
                return false;
            }
        }

        // check diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (queen[row - i][col - i]) {
                return false;
            }
        }

        // check diagonal right
        int maxRight = Math.min(row, queen[0].length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (queen[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }
}
