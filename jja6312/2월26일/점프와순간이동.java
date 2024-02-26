class Solution {
    public int solution(int n) {

        // N은 1이상이므로, ans는 무조건 한 칸은 간다.

        int ans = 0;
        // 2로나누었을때 짝수면 무료로 이동가능하다.
        // 홀수일때, 필연적으로 한 칸은 더 가야한다.

        while (n >= 1) {// n이 1이상일때까지 반복.
            if (n % 2 == 0) {// 짝수면
                n /= 2;// 나누고 다음 반복문으로.

            } else {// 홀수라면
                n--;
                ans++;
                n /= 2;
            }

        }

        return ans;
    }
}