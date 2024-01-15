import java.util.Arrays;

class Solution30 {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));

        if (arr[0].equals("0")) {
            return "0";
        }
        String answer = "";

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }

        return answer;
    }
}