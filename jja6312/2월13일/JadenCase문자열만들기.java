import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String prevChar = " ";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i)) && prevChar.equals(" ")) {
                answer += Character.toUpperCase(s.charAt(i));
                prevChar = "" + s.charAt(i);
            } else if (Character.isAlphabetic(s.charAt(i)) && !prevChar.equals(" ")) {
                answer += Character.toLowerCase(s.charAt(i));
                prevChar = "" + s.charAt(i);
            } else if (s.charAt(i) == ' ') {
                answer += " ";
                prevChar = " ";
            } else {
                answer += s.charAt(i);
                prevChar = "" + s.charAt(i);
            }
        }

        return answer;
    }
}