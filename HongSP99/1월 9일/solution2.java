class Solution {
    public static int[] solution(String s){
        int[] answer = new int[2];
        int zero_cnt = 0;
        int rotate_cnt = 0;

        while(!s.equals("1")){
            int one_cnt = 0;
            rotate_cnt++;
            char[] s_ch = s.toCharArray();
            for (char sCh : s_ch) {
                if (sCh == '0') {
                    zero_cnt++;
                } else {
                    one_cnt++;
                }
            }
            //2진법으로 바꿀 때 toBinaryString()!!
            s = Integer.toBinaryString(one_cnt);
        }

        answer[0] = rotate_cnt;
        answer[1] = zero_cnt;

        return answer;
    }
}
