class Solution {
    public int solution(int n) {
        int answer = 0;

        int nMinus1 = n-1;

        return findDivisor(nMinus1);
    }

    public int findDivisor(int nMinus1){
        for(int i = 2 ; i <= Math.sqrt(nMinus1) ; i++){
            if(nMinus1 % i == 0){
                return i;
            }
        }
        return nMinus1;
    }
}
