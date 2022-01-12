package com.coupang.tb3.project1.week3;

import java.util.Arrays;
import java.util.Random;

public class Minesweeper {

    public static void main(String[] args) {
        Integer[] parsed = Arrays.stream(args)
          .map(Integer::new)
          .toArray(Integer[]::new);
        int m = parsed[0], n = parsed[1], k = parsed[2];
        boolean[][] board = generateBoard(m, n, k);
        printBoard(board);
    }

    private static void printBoard(boolean[][] board) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                stringBuilder.append(getCharacter(board, row, col) + "  ");
            }
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder.toString());
    }

    enum Direction {
        ABOVE(0, 1),
        ABOVE_RIGHT(1, 1),
        RIGHT(1, 0),
        BELOW_RIGHT(1, -1),
        BELOW(0, -1),
        BELOW_LEFT(-1, -1),
        LEFT(-1, 0),
        ABOVE_LEFT(-1, 1);

        private int x;
        private int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private static char getCharacter(boolean[][] board, int row, int col) {
        if (board[row][col]) {
            return '*';
        }
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for (Direction direction : Direction.values()) {
            int x = col + direction.getX();
            int y = row + direction.getY();
            if (x >= 0 && x < n && y >= 0 && y < m && board[y][x]) {
                count++;
            }
        }
        return (char) ('0' + count);
    }

    private static boolean[][] generateBoard(int m, int n, int k) {
        boolean[][] board = new boolean[m][n];
        Random random = new Random();
        for(int i = 0; i < k; i++) {
            for (int rand = random.nextInt(m * n);; rand = random.nextInt(m * n)) {
                if (!board[rand / n][rand % n]) {
                    board[rand / n][rand % n] = true;
                    break;
                }
            }
        }
        return board;
    }
}
