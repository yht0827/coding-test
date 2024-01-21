class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        long requiredMoney = (long)price * (long)(count*(count+1)/2); //필요한 가격
        answer = requiredMoney - money; //필요한 가격 - 현재 가지고 있는 돈

        if(answer < 0){
            return 0; //만약 금액이 부족하지 않으면 0을 리턴
        }

        return answer;
    }
}
