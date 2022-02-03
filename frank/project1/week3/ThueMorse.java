public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        
        String[][] array = new String[n][n];
        int index = 1;
        array[0][0] = "+";
        
        System.out.print("+  ");
        int end = 1;
        while(index < n) {
            int count = 0;
            for(int i=0 ; i<end ; i++) {
                if(array[0][i].equals("+")) {
                    array[0][index] = "-";
                    index++;
                    count ++;
                    System.out.print("-  ");
                }
                else if(array[0][i].equals("-")) {
                    array[0][index] = "+";
                    index++;
                    count ++;
                    System.out.print("+  ");
                }
                
                if(index >= n) break;
            }
            end += count;
            
        }
        System.out.print("\n");
        int current_row = 1;
        
        end = 1;
        while(current_row < n) {
            int count = 0;    
            for(int i=0 ; i<end ; i++) {
                for(int j=0; j<n ; j++) {
            
                    if(array[i][j].equals("+")) {
                        array[current_row][j] = "-";
                        System.out.print("-  ");
                    }
                    else if(array[i][j].equals("-")) {
                        array[current_row][j] = "+";
                        System.out.print("+  ");
                    }
                }
                current_row++;
                count++;
                System.out.print("\n");
                if(current_row >= n) break;
            }
            end += count;
        }
    }
}
