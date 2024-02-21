import java.util.*;

public class Solution {
    public int[] solution(int[] answers) {
        int[][] supo = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] cnt = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (supo[j][i % supo[j].length] == answers[i]) {
                    cnt[j]++;
                }
            }
        }

        int max_cnt = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max_cnt == cnt[i]) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
