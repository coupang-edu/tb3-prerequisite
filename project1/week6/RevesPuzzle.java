package project1.week6;

public class RevesPuzzle {
    private static void RevePuzzle(int numDisk, String from, String to, String temp1, String temp2) {
        if (numDisk == 0) return;
        int numDiskMove = (int) (Math.round(numDisk + 1 - Math.sqrt(2 * numDisk + 1)));
        RevePuzzle(numDiskMove, from, temp1, to, temp2);
        hanoiTower(numDisk, numDiskMove, from, temp2, to);
        RevePuzzle(numDiskMove, temp1, to, from, temp2);
    }

    private static void hanoiTower(int numDisk, int poleNum, String from, String to, String temp) {
        if (numDisk == poleNum) return;
        hanoiTower(numDisk-1, poleNum, from, temp, to); // from -> temp 
        System.out.println("Move disc " + numDisk + " from " + from + " to " + to);
        hanoiTower(numDisk-1, poleNum, temp, to, from); // temp -> to
    }
    public static void main(String[] args) {
        int numDisk = Integer.parseInt(args[0]);
        RevePuzzle(numDisk, "A", "D", "B", "C");
    }
}
