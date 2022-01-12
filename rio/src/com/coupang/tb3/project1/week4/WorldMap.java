package com.coupang.tb3.project1.week4;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import java.util.ArrayList;
import java.util.List;

public class WorldMap {

    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap();
        worldMap.print(worldMap.read());
    }

    private Map read() {
        int width = StdIn.readInt();
        int height = StdIn.readInt();


        List<Region> regions = new ArrayList<>();
        for(;!StdIn.isEmpty();) {
            String name = StdIn.readString();
            int numberOfVertices = StdIn.readInt();
            List<Coordinate> coordinates = new ArrayList<>();
            for (int i = 0; i < numberOfVertices; i++) {
                double x = StdIn.readDouble();
                double y = StdIn.readDouble();
                coordinates.add(new Coordinate(x, y));
            }
            regions.add(new Region(name, numberOfVertices, coordinates));
        }
        Map map = new Map(width, height, regions);
        return map;
    }

    private void print(Map map) {
        StdDraw.setCanvasSize(map.getWidth(), map.getHeight());
        StdDraw.setXscale(0, map.getWidth());
        StdDraw.setYscale(0, map.getHeight());

        for (Region region : map.getRegions()) {
            StdDraw.polygon(region.getxCoordinates(), region.getyCoordinates());
        }
    }

    class Map {
        private int width;
        private int height;
        private List<Region> regions;

        public Map(int width, int height, List<Region> regions) {
            this.width = width;
            this.height = height;
            this.regions = regions;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public List<Region> getRegions() {
            return regions;
        }

    }

    class Region {
        private String name;
        private int numberOfVertices;
        private List<Coordinate> coordinates;
        private double[] xCoordinates;
        private double[] yCoordinates;

        public Region(String name, int numberOfVertices,
          List<Coordinate> coordinates) {
            this.name = name;
            this.numberOfVertices = numberOfVertices;
            this.coordinates = coordinates;
            xCoordinates = new double[coordinates.size()];
            yCoordinates = new double[coordinates.size()];
            for (int i = 0; i < coordinates.size(); i++) {
                Coordinate coordinate = coordinates.get(i);
                xCoordinates[i] = coordinate.getX();
                yCoordinates[i] = coordinate.getY();
            }
        }

        public double[] getxCoordinates() {
            return xCoordinates;
        }

        public double[] getyCoordinates() {
            return yCoordinates;
        }
    }

    class Coordinate{
        private double x;
        private double y;

        public Coordinate(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }
}
