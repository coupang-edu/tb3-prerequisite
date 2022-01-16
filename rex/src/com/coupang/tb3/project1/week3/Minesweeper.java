package com.coupang.tb3.project1.week3;

public class Minesweeper {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        boolean[][] map = new boolean[m][n];
        while (k > 0) {
            int pos = (int) (Math.random() * m * n);
            int row = pos / n;
            int col = pos % n;
            if (!map[row][col]) {
                map[row][col] = true;
                k--;
            }
        }

        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j]) {
                    System.out.print("*  ");
                } else {
                    int count = 0;

                    for (int d = 0; d < dir.length; d++) {
                        int nextRow = i + dir[d][0];
                        int nextCol = j + dir[d][1];

                        if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                            continue;
                        }

                        if (map[nextRow][nextCol]) {
                            count++;
                        }
                    }

                    System.out.print(count + "  ");
                }
            }
            System.out.println();
        }
    }
}
