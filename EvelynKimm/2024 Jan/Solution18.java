class Solution18 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (s.length() > 1) {
            int countOne = 0;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '0') {
                    answer[1]++;
                } else {
                    countOne++;
                }
            }
            s = Integer.toBinaryString(countOne);
            answer[0]++;
        }
        return answer;
    }
}