public class WorldMap {

    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            String regionName = StdIn.readString();
            int numberOfVertices = StdIn.readInt();
            double[] x = new double[numberOfVertices];
            double[] y = new double[numberOfVertices];

            for (int i = 0; i < numberOfVertices; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }
    }
}
