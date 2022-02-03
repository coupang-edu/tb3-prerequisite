public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        
        int[] numbers = new int[n+2];
        
        for(int i=0 ; i<trials ; i++) {
            int times=1;
            int[] bday = new int[n+1];
            while(true) {
                
                int day = (int)(Math.random() * (n-1))+1;
                //System.out.print(day+" / "+bday[day]+", ");
                if(bday[day] == 1) {
                    break;
                }
                else bday[day] = 1;
                times ++;
            }
            numbers[times] = numbers[times] + 1;
            //System.out.println("\n ###### "+ times + "/"+numbers[times]);
        }
        
        int sum = 0;
        for(int i=1 ; i<=n ; i++) {
            sum += numbers[i];
            double fraction = (double)sum/(double)trials; 
            System.out.println(i+"   "+numbers[i]+"    "+fraction);
            if(fraction >= 0.5) break;
        }
        
    }
}
