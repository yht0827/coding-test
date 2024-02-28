class Solution {
    public int solution(int n) {

        String three = Integer.toString(n,3);
        String threeReverse = "";
        for(long i=three.length()-1; i>=0; i--){
            threeReverse+=three.charAt((int)i);
        }
        long threeReverseInt = Long.parseLong(threeReverse);
        String threeStr = ""+threeReverseInt;

        String answerStr = threeStr;
        int mul = 1;
        long cntDown = answerStr.length();
        int sum = 0;
        while(cntDown>0){
            cntDown--;//가장첫번쨰 cntDown이 length()-1이되고, 가장마지막은 0이됨.
            sum+=Integer.parseInt(""+answerStr.charAt((int)cntDown)) * mul; //3진수에맞게 계산
            mul*=3;
        }



        int answer = sum;

        return answer;
    }
}