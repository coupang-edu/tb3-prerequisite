public class WorldMap {
    public static void main(String[] args) {
    
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0,width);
        StdDraw.setYscale(0,height);
        
        while(!StdIn.isEmpty()) {
            String region = StdIn.readString();
            int number = StdIn.readInt();
            double[] x = new double[number];
            double[] y = new double[number];
            for(int i=0 ; i< number ; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }
    }
}
