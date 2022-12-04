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

    public static void main(String[] args) {
        System.out.println(getCommonChar("vJrwpWtwJgWrhcsFMMfFFhFp"));    }
}
