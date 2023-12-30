import java.util.LinkedList;
import java.util.Queue;

class Solution6 {
    public int solution(int[] queue1, int[] queue2) {

        int answer = 0;

        long sum1 = getSum(queue1);
        long sum2 = getSum(queue2);

        Queue<Integer> q1 = makeQueue(queue1);
        Queue<Integer> q2 = makeQueue(queue2);

        while (sum1 != sum2) {
            int num = 0;

            // early exit
            if(answer > (queue1.length + queue2.length) * 2) {
                return -1;
            }
            if (sum1 < sum2) {
                num = q2.poll();
                q1.add(num);

                sum1 += num;
                sum2 -= num;
            }
            else {
                num = q1.poll();
                q2.add(num);
                sum1 -= num;
                sum2 += num;
            }
            answer++;
        }
        return answer;
    }

    private int getSum(int[] queue) {
        int total = 0;
        for (int j : queue) {
            total += j;
        }
        return total;
    }

    private Queue<Integer> makeQueue(int[] nums) {
        Queue<Integer> q = new LinkedList<>();

        for (int num : nums) {
            q.add(num);
        }
        return q;
    }
}
