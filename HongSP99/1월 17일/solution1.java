class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int min = Math.min(n, m);
        int max = Math.max(n, m);

        answer[0] = gcd(max, min);
        answer[1] = (min*max)/answer[0];

        return answer;
    }

    public int gcd(int max, int min){
        int remain;
        while(min > 0){
            remain = max%min;
            max = min;
            min = remain;
        }
        return max;
    }
}
