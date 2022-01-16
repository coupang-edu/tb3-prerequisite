package com.coupang.tb3.project2.week8;

import com.coupang.tb3.project1.StdLibrary.In;

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int idx = 0;
        int maxCnt = 0;
        while (idx < dna.length()) {
            int cnt = 0;
            while (idx <= dna.length() - 3 && dna.substring(idx, idx + 3).equals("CAG")) {
                cnt++;
                idx += 3;
            }
            maxCnt = Math.max(maxCnt, cnt);
            idx++;
        }

        return maxCnt;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String copy = s;
        copy = copy.replace(" ", "");
        copy = copy.replace("\n", "");
        copy = copy.replace("\t", "");

        return copy;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10) {
            return "not human";
        } else if (maxRepeats < 36) {
            return "normal";
        } else if (maxRepeats < 40) {
            return "high risk";
        } else if (maxRepeats < 181) {
            return "Huntington's";
        } else {
            return "not human";
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        String data = removeWhitespace(in.readAll());
        int maxRepeats = maxRepeats(data);
        String diagnose = diagnose(maxRepeats);

        System.out.println("max repeats = " + maxRepeats);
        System.out.println(diagnose);
    }
}
