class Solution24 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int cnt = 0;
        int zeroCnt = 0;

        for (int lotto : lottos) {
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    cnt++;
                }
            }
            if (lotto == 0) {
                zeroCnt++;
            }
        }
        int maxRank = rank(cnt + zeroCnt);
        int minRank = rank(cnt);

        return new int[]{maxRank, minRank};
    }

    private int rank(int sameNumCnt) {
        if (sameNumCnt == 6) {
            return 1;
        } else if (sameNumCnt == 5) {
            return 2;
        } else if (sameNumCnt == 4) {
            return 3;
        } else if (sameNumCnt == 3) {
            return 4;
        } else if (sameNumCnt == 2) {
            return 5;
        } else {
            return 6;
        }
    }
}