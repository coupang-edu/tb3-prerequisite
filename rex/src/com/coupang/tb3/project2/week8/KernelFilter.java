package com.coupang.tb3.project2.week8;

import com.coupang.tb3.project1.StdLibrary.Picture;
import java.awt.Color;

public class KernelFilter {

    private static final double[][] IDENTITY_RULE = {
      {0, 0, 0},
      {0, 1, 0},
      {0, 0, 0}
    };
    private static final double[][] GAUSSIAN_RULE = {
      {1.0 / 16, 2.0 / 16, 1.0 / 16},
      {2.0 / 16, 4.0 / 16, 2.0 / 16},
      {1.0 / 16, 2.0 / 16, 1.0 / 16}
    };
    private static final double[][] SHARPEN_RULE = {
      {0, -1, 0},
      {-1, 5, -1},
      {0, -1, 0}
    };
    private static final double[][] LAPLACIAN_RULE = {
      {-1, -1, -1},
      {-1, 8, -1},
      {-1, -1, -1}
    };
    private static final double[][] EMBOSS_RULE = {
      {-2, -1, 0},
      {-1, 1, 1},
      {0, 1, 2}
    };
    private static final double[][] MOTION_BLUR_RULE = {
      {1.0 / 9, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 1.0 / 9, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 1.0 / 9, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 1.0 / 9, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 1.0 / 9, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 1.0 / 9, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 1.0 / 9, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1.0 / 9, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 1.0 / 9},
    };


    private static Picture filter(Picture picture, double[][] rule) {

        Picture newPicture = new Picture(picture.width(), picture.height());

        for (int row = 0; row < picture.height(); row++) {
            for (int col = 0; col < picture.width(); col++) {
                double red = 0;
                double green = 0;
                double blue = 0;

                int startIdx = -rule.length / 2;
                for (int i = 0; i < rule.length; i++) {
                    for (int j = 0; j < rule[0].length; j++) {
                        int refRow = row + (startIdx + i);
                        int refCol = col + (startIdx + j);
                        while (refRow < 0) {
                            refRow = picture.height() + refRow;
                        }
                        while (refCol < 0) {
                            refCol = picture.width() + refCol;
                        }
                        while (refRow >= picture.height()) {
                            refRow -= picture.height();
                        }
                        while (refCol >= picture.width()) {
                            refCol -= picture.width();
                        }

                        Color color = picture.get(refCol, refRow);
                        red += color.getRed() * rule[i][j];
                        green += color.getGreen() * rule[i][j];
                        blue += color.getBlue() * rule[i][j];
                    }
                }

                red = Math.max(Math.min(red, 255), 0);
                green = Math.max(Math.min(green, 255), 0);
                blue = Math.max(Math.min(blue, 255), 0);
                newPicture
                  .set(col, row, new Color((int) Math.round(red), (int) Math.round(green), (int) Math.round(blue)));
            }
        }

        return newPicture;
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        return filter(picture, IDENTITY_RULE);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        return filter(picture, GAUSSIAN_RULE);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        return filter(picture, SHARPEN_RULE);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        return filter(picture, LAPLACIAN_RULE);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        return filter(picture, EMBOSS_RULE);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        return filter(picture, MOTION_BLUR_RULE);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture picture = new Picture("baboon.png");
        picture.show();

        identity(picture).show();
        gaussian(picture).show();
        sharpen(picture).show();
        laplacian(picture).show();
        emboss(picture).show();
        motionBlur(picture).show();
    }
}
