import java.util.Stack;

class Solution {
	public static int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = numbers.length - 1; i >= 0; i--) {
			while (!stack.isEmpty()) {
				int num = stack.peek();
				if (num > numbers[i]) {
					answer[i] = num;
					break;
				} else {
					stack.pop();
				}
			}
			if (stack.isEmpty()) {
				answer[i] = -1;
			}

			stack.push(numbers[i]);
		}
		return answer;
	}
}