class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] allStudent = new int[n];

        for (int i = 0; i < n; i++) {
            allStudent[i] = 1;
        }

        for (int x : lost) {
            allStudent[x - 1]--;
        }

        for (int plus : reserve) {
            allStudent[plus - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (allStudent[i] == 0) {// 체육복이없다면
                if (i != 0 && allStudent[i - 1] == 2) {// 왼쪽에서 빌리거나
                    allStudent[i - 1]--;
                    allStudent[i]++;
                } else if (i != n - 1 && allStudent[i + 1] == 2) {// 오른쪽에서 빌리자.
                    allStudent[i + 1]--;
                    allStudent[i]++;
                }
            }
        }

        for (int x : allStudent) {
            if (x >= 1) {
                answer++;
            }
        }

        return answer;
    }
}