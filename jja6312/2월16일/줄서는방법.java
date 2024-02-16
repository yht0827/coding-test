import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        long factorial = 1;

        // 사용 가능한 숫자 목록 생성
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial *= i;
        }

        k--; // 0부터 시작하는 인덱스 조정

        for (int i = 0; i < n; i++) {
            factorial /= (n - i);
            int index = (int) (k / factorial);
            answer[i] = numbers.get(index);
            numbers.remove(index);
            k %= factorial;
        }

        return answer;
    }
}
