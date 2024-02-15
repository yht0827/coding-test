import java.util.*;

class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < number.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));

        }

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        return new String(result);

    }
}