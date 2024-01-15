class Solution28 {
    public int solution(String s) {
        int answer = s.length();

        for(int i = 1; i <= s.length() / 2; i++) {
            String target = s.substring(0, i);
            String cur = "";
            int cnt = 1;
            StringBuilder sb = new StringBuilder();

            for(int start = i; start <= s.length(); start += i) {
                if(start + i >= s.length()) {
                    cur = s.substring(start, s.length());
                }
                else {
                    cur = s.substring(start, start + i);
                }

                if(cur.equals(target)) {
                    cnt++;
                }
                else if(cnt == 1){
                    sb.append(target);
                    target = cur;
                }
                else {
                    sb.append(cnt).append(target);
                    target = cur;
                    cnt = 1;
                }
            }
            if(i != target.length()) sb.append(target);

            answer = Math.min(answer, sb.toString().length());
        }

        return answer;
    }
}
