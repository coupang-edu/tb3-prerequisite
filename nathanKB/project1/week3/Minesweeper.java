public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        char[][] ground = new char[m][n];

        int t = 0;
        while (t < k) {
            int rand = (int) (Math.random() * m * n);
            int q = rand / n;
            int r = rand % n;
            if (ground[q][r] != '*') {
                ground[q][r] = '*';
                t++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ground[i][j] != '*') {
                    char num = '0';
                    if (i != 0 && j != 0 && ground[i - 1][j - 1] == '*') num++;
                    if (i != 0 && ground[i - 1][j] == '*') num++;
                    if (i != 0 && j != n - 1 && ground[i - 1][j + 1] == '*') num++;
                    if (j != n - 1 && ground[i][j + 1] == '*') num++;
                    if (i != m - 1 && j != n - 1 && ground[i + 1][j + 1] == '*') num++;
                    if (i != m - 1 && ground[i + 1][j] == '*') num++;
                    if (i != m - 1 && j != 0 && ground[i + 1][j - 1] == '*') num++;
                    if (j != 0 && ground[i][j - 1] == '*') num++;
                    ground[i][j] = num;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ground[i][j]);
                if (j == n - 1) {
                    System.out.println();
                } else {
                    System.out.print("  ");
                }
            }
        }
    }
}
