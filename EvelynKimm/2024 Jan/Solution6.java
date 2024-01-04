import java.util.Stack;

class Solution6 {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];

        stack.push(0);

        for(int i=0; i< numbers.length; i++) {
            while (!stack.empty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
    return answer;
    }
}