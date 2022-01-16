package com.coupang.tb3.project2.week9;

public class Clock {

    private static final int MAX_HOUR = 24;
    private static final int MAX_MINUTE = 60;

    private int h;
    private int m;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h >= MAX_HOUR || m < 0 || m >= MAX_MINUTE) {
            throw new IllegalArgumentException();
        }
        this.h = h;
        this.m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5 || s.indexOf(':') != 2 || s.lastIndexOf(':') != 2) {
            throw new IllegalArgumentException();
        }

        int hLocal = Integer.parseInt(s.substring(0, 2));
        int mLocal = Integer.parseInt(s.substring(3, 5));

        if (hLocal < 0 || hLocal >= MAX_HOUR || mLocal < 0 || mLocal >= MAX_MINUTE) {
            throw new IllegalArgumentException();
        }
        h = hLocal;
        m = mLocal;

    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", h, m);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (h < that.h) {
            return true;
        } else if (h > that.h) {
            return false;
        } else {
            return m < that.m;
        }
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        m++;
        if (m == MAX_MINUTE) {
            h++;
            if (h == MAX_HOUR) {
                h = 0;
            }
            m = 0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException();
        }
        m += delta;
        h += m / MAX_MINUTE;

        m %= MAX_MINUTE;
        h %= MAX_HOUR;
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock clock = new Clock(23, 59);
        System.out.println(clock);
        clock.tic();
        clock.toc(20);
        System.out.println(clock);
        System.out.println(clock.isEarlierThan(new Clock("00:22")));
    }
}
