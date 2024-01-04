import java.util.*;

class Solution {
    private Stack<int[]> stack = new Stack<>();

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        for (int i=0; i<numbers.length; i++) {
            while (!stack.isEmpty()) {
                int[] data = stack.peek();
                if (data[0] >= numbers[i]) break;

                answer[data[1]] = numbers[i];
                stack.pop();
            }
            stack.push(new int[]{numbers[i], i});
        }
        return answer;
    }
}
