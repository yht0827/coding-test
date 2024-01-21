class Solution39 {
    public long solution(int price, int money, int count) {
        long costForPlaying = 0;
        long answer = 0;

        for (int i=1; i<count+1; i++) {
            costForPlaying += price * i;
        }

        if (costForPlaying > money) {
            answer = costForPlaying - money;
        }

        return answer;
    }
}