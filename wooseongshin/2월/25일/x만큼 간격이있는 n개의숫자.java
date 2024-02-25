class Solution {
    public long[] solution(int x, int n) {

        long[] answer = new long[n];
        long sumx=0;
        for(int i=0;i<n;i++){
            sumx = sumx + x;
            answer[i]=sumx;
        }
        return answer;
    }
}
