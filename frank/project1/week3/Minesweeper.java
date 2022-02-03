public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        boolean[][] cells = new boolean[m][n];
        
        if(k < m*n/2) {
            int stars = 0;
            while(stars != k) {
                int loc = (int)(Math.random() * (m * n - 1));
                
                int x = loc / n;
                int y = loc % n;
                if(!cells[x][y]) {
                    cells[x][y] = true;
                    stars++;
                }
            }
        }
        else {
            for (int i = 0 ; i < m ; i++) 
                for (int j = 0 ; j < n ;j++) 
                    cells[i][j] = true;
            int stars = 0;
            while(stars != m*n - k ) {
                int loc = (int)(Math.random() * (m * n - 1));
                
                int x = loc / n;
                int y = loc % n;
                if(cells[x][y]) {
                    cells[x][y] = false;
                    stars++;
                }
            }   
        }
        
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ;j++) {
                int count = 0;
                if (!cells[i][j]) {
                    if (i+1 < m) {
                        if(cells[i+1][j]) count++;
                    }
                    if (i-1 >= 0) {
                        if(cells[i-1][j]) count++;
                    }
                    if (j+1 < n) {
                        if(cells[i][j+1]) count++;
                    }
                    if (j-1 >= 0) {
                        if(cells[i][j-1]) count++;
                    }
                    if (i+1 < m && j+1 < n) {
                        if(cells[i+1][j+1]) count++;
                    }
                    if (i+1 < m && j-1 >=0) {
                        if(cells[i+1][j-1]) count++;
                    }
                    if (i-1 >= 0 && j+1 < n) {
                        if(cells[i-1][j+1]) count++;
                    }
                    if (i-1 >= 0 && j-1 >=0) {
                        if(cells[i-1][j-1]) count++;
                    }
                    //cells[i][j] = Integer.toString(count);
                    System.out.print(count+"  ");
                }
                else System.out.print("*  ");
            }
            System.out.print("\n");
        }
    }
}
