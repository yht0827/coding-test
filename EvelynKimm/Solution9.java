class Solution9 {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            for (int j=0; j<index; j++) {
                c += 1;
                if (c > 'z') {
                    c -= 26;  // 아스키
                } if (skip.contains(String.valueOf(c))) {
                    j--;
                }
            }
            answer += c;
        }
        return answer;
    }
}
