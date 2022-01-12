package project1.week3;

public class Minesweeper {
    final static int step[][]  = {{1,0}, {-1,0}, {0,1}, {0,-1},{1,1}, {-1,-1}, {-1,1}, {1,-1}};

    public static void main(String[] args) { 
        Integer m = Integer.parseInt(args[0]);
        Integer n = Integer.parseInt(args[1]);
        int num_mine = Integer.parseInt(args[2]);
        int[] mine_map = new int[m*n];

        for(int i=0; i<num_mine; i++) {
            int pos = (int) (Math.random() * m * n);
            if(mine_map[pos] == 1) {
                i--;
                continue;
            }
            mine_map[pos] = 1;
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mine_map[i*n+j] == 1) {
                    System.out.print("*  ");
                    continue;
                }
                int mine_cnt = 0;
                for(int s=0; s<8; s++) {
                    int x_pos = j + step[s][0];
                    int y_pos = i + step[s][1];
                    if(x_pos < 0 || y_pos < 0 || x_pos >=n || y_pos >= m)
                        continue;
                    if(mine_map[y_pos*n + x_pos] == 1)
                        mine_cnt++;
                }
                System.out.print(mine_cnt + "  ");
            }
            System.out.println();
        }
    }
}
