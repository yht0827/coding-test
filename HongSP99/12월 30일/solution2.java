import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0l;
        long sum2 = 0l;
        int buffer;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        if ((sum1 + sum2) % 2 == 1) {
            answer = -1;
        } else {
            while (sum1 != sum2 && answer < queue1.length * 4) {
                if (sum1 > sum2) {
                    buffer = q1.poll();
                    q2.add(buffer);
                    sum1 -= buffer;
                    sum2 += buffer;
                } else {
                    buffer = q2.poll();
                    q1.add(buffer);
                    sum1 += buffer;
                    sum2 -= buffer;
                }
                answer++;
            }
            if (sum1 != sum2) answer = -1;
        }
        return answer;
    }
}
