class Solution {
        static int[] r, a, ans;
        static boolean isFind;
        static int max;

        public static int[] solution(int n, int[] info) {
            a = info.clone();
            r = new int[11];

            max = Integer.MIN_VALUE;
            ans = new int[11];
            isFind = false;
            shoot(0, n, 0, 0);

            return isFind == true? ans: new int[] {-1};
        }

    private static void shoot(int depth, int rest, int apeach, int ryan) {
        if(depth == 11) {
            if(rest == 0 && ryan > apeach) {
                isFind = true;
                if(max < (ryan - apeach)) {
                    max = ryan - apeach;
                    ans = r.clone();
                } else if(max == (ryan - apeach)) {
                    // 가장 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.
                    for (int i = 10; i >= 0; i--) {
                        if(r[i] > ans[i]) {
                            ans = r.clone();
                            return;
                        } else if(r[i] < ans[i]) return;
                    }
                }
            }
            return;
        }

        // 점수를 안 낼꺼냐 : 둘 다 0 일 경우 : 일단 어피치가 0 점이어야 가능성이라도 있음 
        if(a[depth] == 0) {
            shoot(depth + 1, rest, apeach, ryan);
        } 

        // 점수를 낼 경우 : 어피치보다 무조건 많이 쏴야 함, 근데 점수 차이가 많이 날려면 1개만 차이나야 화살을 아낄 수 잇음
        if(rest > a[depth]) {
            r[depth] = a[depth] + 1;
            shoot(depth + 1, rest - a[depth] - 1, apeach, ryan + (10 - depth));
            r[depth] = 0;
        }

        // 점수를 줄 경우 : 어피치와 똑같은수의 화살을 쏘거나 어피치보다 적게 쏘거나의 경우의 수
        if(a[depth] != 0) {
            for (int i = 0; i < a[depth]; i++) {
                if(rest >= i) {
                    r[depth] = i;
                    shoot(depth + 1, rest - i, apeach + (10 - depth), ryan);
                    r[depth] = 0;
                }
            }
        }
    }
}
