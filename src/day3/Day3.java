package day3;

import utils.MyFiles;

import java.io.IOException;

public class Day3 {
    //   splits a string in half
    public static String[] split(String s) {
        return new String[]{s.substring(0, s.length() / 2), s.substring(s.length() / 2)};
    }

    // takes two strings and returns the first character that appears in both
    public static char getCommonChar(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s2.contains(s1.substring(i, i + 1))) {
                return s1.charAt(i);
            }
        }
        return ' ';
    }

    // takes a string and returns the character that appears in both halves
    public static char getCommonChar(String s) {
        return getCommonChar(split(s)[0], split(s)[1]);
    }

    // takes a letter and returns a number
//    Lowercase item types a through z have priorities 1 through 26.
//Uppercase item types A through Z have priorities 27 through 52.
    public static int getPriority(char c) {
        return c >= 'a' ? c - 'a' + 1 : c - 'A' + 27;
    }

    // iterates over three strings at a time and returns the any common character
    public static char getCommonChar(String s1, String s2, String s3) {
        for (int i = 0; i < s1.length(); i++) {
            if (s2.contains(s1.substring(i, i + 1)) && s3.contains(s1.substring(i, i + 1))) {
                return s1.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) throws IOException {
        String[] strings = MyFiles.fileToList("src/day3/input.txt");
//        iterate over the strings and print the common character
        int total = 0;
        for (int i = 0; i < strings.length; i += 3) {
            char c = getCommonChar(strings[i], strings[i + 1], strings[i + 2]);
            total += getPriority(c);
        }

        System.out.println(total);
    }
}
