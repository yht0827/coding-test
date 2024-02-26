class Solution {
    public String solution(String phone_number) {
        String answer = "";

        int len = phone_number.length();

        for (int i = 0; i < len - 4; i++) {
            answer += "*";
        }

        for (int i = len - 4; i < len; i++) {
            answer += phone_number.charAt(i);
        }

        return answer;
    }
}