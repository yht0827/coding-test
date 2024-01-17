public class Solution34 {
    static private int[] res = new int[11];
    static private int[] ryan= {-1};
    static private int max = Integer.MIN_VALUE;
    public static int[] solution(int n, int[] info) {
        back(0,n,info);

        if (max == -1) {
            ryan = new int[1];
            ryan[0] = -1;
        }
        return ryan;
    }

    public static void back(int depth, int n, int[] info) {

        if (depth == n) {
            int diff = score(info);
            if (max <= diff) {
                max = diff;
                ryan = res.clone();
            }
            return;
        }

        for (int i = 0; i < info.length && res[i] <= info[i]; i++) {
            res[i] += 1;
            back(depth + 1, n, info);
            res[i] -= 1;
        }
    }

    public static int score(int[] info) {
        int apeach=0;
        int ryan=0;

        for(int i=0; i<res.length; i++) {
            if (info[i] == 0 && res[i] == 0) {
                continue;
            }
            if (info[i] >= res[i]) {
                apeach += (10 - i);
            } else {
                ryan += (10 - i);
            }
        }

        int diff = ryan - apeach;

        if (diff <= 0) {
            return -1;
        }
        return diff;
    }
}