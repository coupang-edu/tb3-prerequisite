package com.coupang.tb3.project2.week10;

import com.coupang.tb3.project1.StdLibrary.In;
import com.coupang.tb3.project1.StdLibrary.StdDraw;
import java.util.Arrays;

public class BarChartRacer {

    public static void main(String[] args) {
        String fileName = args[0];
        int k = Integer.parseInt(args[1]);

        In in = new In(fileName);
        String title = in.readLine();
        String xAxisLabel = in.readLine();
        String dataSource = in.readLine();
        in.readLine();

        BarChart barChart = new BarChart(title, xAxisLabel, dataSource);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.readLine());
            String caption = "";
            Bar[] bars = new Bar[n];
            for (int i = 0; i < n; i++) {
                String line = in.readLine();
                String[] words = line.split(",");
                caption = words[0];
                String name = words[1];
                int value = Integer.parseInt(words[3]);
                String category = words[4];
                bars[i] = new Bar(name, value, category);
            }

            barChart.reset();
            Arrays.sort(bars);
            for (int i = 0; i < k; i++) {
                Bar bar = bars[n - i - 1];
                barChart.add(bar.getName(), bar.getValue(), bar.getCategory());
            }
            barChart.setCaption(caption);
            StdDraw.clear();
            barChart.draw();
            StdDraw.show();
            StdDraw.pause(100);

            in.readLine();
        }
    }
}
