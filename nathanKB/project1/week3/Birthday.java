public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] countArr = new int[0];
        for (int t = 0; t < trials; t++) {
            boolean[] birthdayArr = new boolean[n];
            int people = 1;
            boolean sameBirthday = false;
            while (!sameBirthday) {
                int birthday = (int) (Math.random() * n);
                if (!birthdayArr[birthday]) {
                    birthdayArr[birthday] = true;
                    people++;
                } else {
                    if (people > countArr.length) {
                        int[] newCountArr = new int[people];
                        for (int i = 0; i < countArr.length; i++) {
                            newCountArr[i] = countArr[i];
                        }
                        countArr = newCountArr;
                    }
                    countArr[people - 1] += 1;
                    sameBirthday = true;
                }
            }
        }
        double fraction = 0;
        int idx = 0;
        while (fraction < 0.5) {
            fraction += (double) countArr[idx] / (double) trials;
            System.out.println(idx + 1 + "\t" + countArr[idx++] + "\t" + fraction);
        }
    }
}
