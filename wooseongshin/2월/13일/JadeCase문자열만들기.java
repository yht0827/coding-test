class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean first = true;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) && first) {
                answer.append(Character.toUpperCase(s.charAt(i)));
            } else {
                answer.append(Character.toLowerCase(s.charAt(i)));
            }
            if (s.charAt(i) == ' ') {
                first = true;
            } else {
                first = false;
            }
        }
        return answer.toString();
    }
}
