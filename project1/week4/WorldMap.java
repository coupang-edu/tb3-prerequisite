package project1.week4;

public class WorldMap {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        int width = StdIn.readInt();
        int height = StdIn.readInt();

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        while (!StdIn.isEmpty()) {
                StdIn.readString();  // region name
                int num = StdIn.readInt();
                double[] x = new double[num];
                double[] y = new double[num];

                for (int i = 0; i < num; i++) {
                        x[i] = StdIn.readDouble();
                        y[i] = StdIn.readDouble();
                }
                StdDraw.polygon(x, y);
        }
        StdDraw.show();
    }
}
