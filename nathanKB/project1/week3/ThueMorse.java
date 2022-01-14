public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] thueMorseSequence = new boolean[n];
        int endIndex = 1;
        int refIndex = 0;
        thueMorseSequence[0] = false;
        for (int i = 1; i < n; i++) {
            thueMorseSequence[i] = !thueMorseSequence[refIndex++];
            if (refIndex == endIndex) {
                refIndex = 0;
                endIndex *= 2;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (thueMorseSequence[i] == thueMorseSequence[j]) {
                    System.out.print('+');
                } else {
                    System.out.print('-');
                }
                if (j == n - 1) {
                    System.out.println();
                } else {
                    System.out.print("  ");
                }
            }
        }

    }
}
