class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for(int i = 0 ; i < nums.length-2 ; i++){
            for(int j = i+1 ; j < nums.length-1 ; j++){
                for(int k = j+1 ; k < nums.length ; k++){
                    int number = nums[i] + nums[j] + nums[k];
                    if(isPrimeNumber(number)){
                        answer++;
                    }
                }
            }
        }


        return answer;
    }

    //중요한 코드!
    public boolean isPrimeNumber(int number){
        for(int i=2 ; i*i<=number; i++) {
        if(number%i ==0) {
            return false; //number가 i의 배수면 소수가 아니므로 false
        }
    }
    return true;
    }
}
