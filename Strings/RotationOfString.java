package Strings;

public class RotationOfString {
    public static void main(String[] args) {
        System.out.println(isRotation("ABAAA", "ABABA"));
        System.out.println(isRotation("BAAAA", "AABAA"));
    }

    private static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s1 + s1).contains(s2);
    }
}
