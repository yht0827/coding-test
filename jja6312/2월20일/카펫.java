class Solution {
    static boolean isTrue = false;
    static int[] arr = new int[2];

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // 8,1
        // default [3,3]

        // 8+2,1+1
        // [3+1,3]

        // 10+2,2+1
        // [4+1,3]

        // 12+2,3*(1+1칸)
        // [5,3+1]

        // 그러니까 거꾸로 가고싶으면,
        // 8+2x+2y = 주어진 왼쪽 값
        // (1+x)*(1+y) = 주어진 오른쪽 값
        int x = 0;
        int y = 0;
        isSatisfyCondition(x, y, brown, yellow);
        // answer = {3+x, 3+y}
        answer[0] = arr[0] + 3;
        answer[1] = arr[1] + 3;

        int max = Math.max(answer[0], answer[1]);
        int min = Math.min(answer[0], answer[1]);
        answer[0] = max;
        answer[1] = min;

        return answer;
    }

    private void isSatisfyCondition(int x, int y, int brown, int yellow) {
        if (8 + 2 * x + 2 * y > brown)
            return; // 갈색 격자 수를 초과하면 리턴
        if ((1 + x) * (1 + y) > yellow)
            return; // 노란색 격자 수를 초과하면 리턴

        if (8 + 2 * x + 2 * y == brown && (1 + x) * (1 + y) == yellow) {
            arr[0] = x;
            arr[1] = y;
            isTrue = true;
        } else {
            if (!isTrue) {
                if (x < y) { // 가로 길이는 세로 길이보다 길거나 같아야 함
                    isSatisfyCondition(x + 1, y, brown, yellow);
                }
                isSatisfyCondition(x, y + 1, brown, yellow);
            }

        }
    }
}