public class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            // 홀수인 경우
            if((numbers[i] & 1) == 1) {
                long lastZero = ~numbers[i] & (numbers[i] + 1);
                numbers[i] |= lastZero; // 가장 낮은 0 비트를 1로 변경
                numbers[i] &= ~(lastZero >> 1); // 변경된 비트 바로 다음의 1을 0으로 변경
            } else {
                // 짝수인 경우, 가장 낮은 자리의 비트를 1로 변경하기만 하면 됩니다.
                numbers[i] |= 1;
            }
            answer[i] = numbers[i];
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        long[] numbers = {2, 7};
        long[] answers = solution.solution(numbers);
        
        for(long answer : answers) {
            System.out.print(answer + " ");
        }
    }
}
