package project1.week3;

import java.util.HashMap;
import java.util.Map;

public class Birthday {
    public static void main(String[] args) { 
        Integer n = Integer.parseInt(args[0]);
        Integer trials = Integer.parseInt(args[1]);
        int[] resultTable = new int[n+2];

        for(int cnt=0; cnt<trials; cnt++) {
            int peopleInRoom = 0;
            boolean[] calender = new boolean[n];
            while (true) {
                int birthday = (int) (Math.random() * n);
                peopleInRoom++;
                if (calender[birthday]) {
                    break;
                } else {
                    calender[birthday] = true;
                }  
            }
            resultTable[peopleInRoom]++;
        }

        int peopleSum = 0;
        for(int i=0; ; i++) {
            peopleSum += resultTable[i];
            double fraction = ((double)peopleSum) / trials;
            System.out.println(i+1 + " " + resultTable[i] + " " + fraction);
            if(fraction > 0.5)
                break;
        }

    }
}
