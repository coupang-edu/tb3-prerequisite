public class ThueMorse {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        boolean[] sequence = new boolean[n];
        int patternSize = 1;
        int patternIndex = 0;
        for (int i = 1; i < n; i++) {
            sequence[i] = !sequence[patternIndex++];
            if (patternIndex == patternSize) {
                patternIndex = 0;
                patternSize *= 2;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sequence[i] == sequence[j]) {
                    System.out.print("+  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}