class Solution {
    public int solution(int[] numbers) {
       
        int sum = 45; //0~9까지 합.
        
        for(int i=0; i<numbers.length; i++){
            sum -= numbers[i];
        }
        return sum;
    }
}
