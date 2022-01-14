package com.coupang.tb3.project1.week3;

public class Minesweeper {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        char[][] arr = new char[m][n];

        for (int i = 0; i < k; i++) {
            int y = (int) (Math.random() * m);
            int x = (int) (Math.random() * n);
            if (arr[y][x] == '*') {
                i--;
                continue;
            }
            arr[y][x] = '*';
        }

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (arr[i][j] == '*') {
                    System.out.printf("* ");
                    continue;
                }
                for(int y = -1 ; y <= 1; y++) {
                    for(int x = -1 ; x <= 1; x++) {
                        if (y == 0 && x == 0 ) continue;
                        if (i + y < 0 || j + x < 0) continue;
                        if (i + y >= m || j + x >= n) continue;
                        if (arr[i + y][j + x] == '*') count++;
                    }
                }
                arr[i][j] = (char) ('0' + count);
                System.out.printf("%c ", arr[i][j]);
            }
            System.out.printf("\n");
        }



    }
}
