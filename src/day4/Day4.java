package day4;

import utils.MyFiles;

import java.io.IOException;

public class Day4 {
    public static void main(String[] args) throws IOException {

        String[] groups = MyFiles.fileToList("src/day4/input.txt");

        //       iterate over the groups and get the ranges
        int total = 0;
        for (String group : groups) {
            int[][] ranges = getRanges(group);

            //  iterate over the ranges
            for (int j = 0; j < ranges.length - 1; j++) {
                int[] range1 = ranges[j];
                int[] range2 = ranges[j + 1];

//                if(oneIsContained(range1, range2)){
//                    total += 1;
//                }
                if (overlaps(range1, range2)) {
                    total += 1;
                }

            }
        }
        System.out.println(total);
    }

    private static boolean oneIsContained(int[] range1, int[] range2) {
        return contains(range1, range2) || contains(range2, range1);
    }

    // checks if either range contains the other range
    private static boolean contains(int[] range1, int[] range2) {
        return range1[0] <= range2[0] && range1[1] >= range2[1];
    }

    // checks if two ranges overlap
    public static boolean overlaps(int[] r1, int[] r2) {
        return (r1[0] <= r2[0] && r1[1] >= r2[0]) || r1[0] <= r2[1] && r1[1] >= r2[1]
                || r2[0] <= r1[0] && r2[1] >= r1[0] || r2[0] <= r1[1] && r2[1] >= r1[1];
    }

    // takes a string and turns it into an array of int ranges
    public static int[][] getRanges(String s) {
        String[] ranges = s.split(",");
        int[][] result = new int[ranges.length][2];
        for (int i = 0; i < ranges.length; i++) {
            String[] range = ranges[i].split("-");
            result[i][0] = Integer.parseInt(range[0]);
            result[i][1] = Integer.parseInt(range[1]);
        }
        return result;
    }


}
