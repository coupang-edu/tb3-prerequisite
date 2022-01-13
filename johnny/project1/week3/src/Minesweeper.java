public class Minesweeper {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int[][] grid = new int[m][n];

        while (k > 0) {
            int i = (int) Math.round(Math.random() * (m - 1));
            int j = (int) Math.round(Math.random() * (n - 1));
            if (grid[i][j] == 0) {
                grid[i][j] = -1;
                k--;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    if (i > 0 && j > 0 && grid[i - 1][j - 1] != -1) {
                        grid[i - 1][j - 1]++;
                    }
                    if (i > 0 && grid[i - 1][j] != -1) {
                        grid[i - 1][j]++;
                    }
                    if (i > 0 && j < n - 1 && grid[i - 1][j + 1] != -1) {
                        grid[i - 1][j + 1]++;
                    }
                    if (j > 0 && grid[i][j - 1] != -1) {
                        grid[i][j - 1]++;
                    }
                    if (j < n - 1 && grid[i][j + 1] != -1) {
                        grid[i][j + 1]++;
                    }
                    if (i < m - 1 && j > 0 && grid[i + 1][j - 1] != -1) {
                        grid[i + 1][j - 1]++;
                    }
                    if (i < m - 1 && grid[i + 1][j] != -1) {
                        grid[i + 1][j]++;
                    }
                    if (i < m - 1 && j < n - 1 && grid[i + 1][j + 1] != -1) {
                        grid[i + 1][j + 1]++;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    System.out.print("*  ");
                } else {
                    System.out.print(grid[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }
}
