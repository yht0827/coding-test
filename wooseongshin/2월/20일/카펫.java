import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] result = solution(10, 2);
        System.out.println(result[0] + ", " + result[1]);
    }

    public static int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        List<Integer> primeNumbers = getDivisors(area);

        for (int i : primeNumbers) {
            if ((i - 2) * (area / i - 2) == yellow) {
                return new int[]{area / i, i};
            }
        }

        return new int[]{};
    }

    public static List<Integer> getDivisors(int n) {
        List<Integer> divisorsList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisorsList.add(i);
            }
        }

        return divisorsList;
    }
}
