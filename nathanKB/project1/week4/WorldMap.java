public class WorldMap {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        while (!StdIn.isEmpty()) {
            StdIn.readString();
            int num = StdIn.readInt();
            double[] xArr = new double[num];
            double[] yArr = new double[num];
            for (int i = 0; i < num; i++) {
                xArr[i] = StdIn.readDouble();
                yArr[i] = StdIn.readDouble();
            }
            StdDraw.polygon(xArr, yArr);
        }
        StdDraw.show();
    }
}
