class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;

        // 1 을 함수라고 보자.
        // n은 1을 재귀적으로 n번 호출하라는 의미라고 하자.
        // 재귀적으로 호출되는 함수는 n을 전달 받고, n-1을 함수 내에서 진행한다.
        // n이 0이될 때까지 진행한다.(n이 0이되면 1만 뱉는것임.)
        // n이 0이라면, 1
        // n이 1이라면, 11011
        // n이 2라면, '11011' '11011' '00000' '11011' '11011'.

        // 문자열을 넣고, 조건문을 주면되겠다.

        Solution solution = new Solution();
        int m = n;

        String all = solution.cal("1", m);

        for (long i = l; i < r + 1; i++) {
            if (all.charAt(i) == '1') { // l,r이 long인것을 고려하지 못했다.
                answer++;
            }
        }

        return answer;
    }

    public String cal(String number, int m) {
        if (m == 0)
            return number;

        String sumNum = "";
        for (int i = 0; i < number.length(); i++) {
            if ((number.charAt(i) + "").equals("1")) {
                sumNum += "11011";
            } else {
                sumNum += "00000";
            }
        }

        sumNum = cal(sumNum, m - 1);
        return sumNum;
    }

}

/*
 * 아래처럼 풀어야 했다.
 * public class Solution {
 * 
 * public int solution(int n, long l, long r) {
 * int answer = 0;
 * for (long i = l; i <= r; i++) {
 * if (isOne(n, i)) {
 * answer++;
 * }
 * }
 * return answer;
 * }
 * 
 * private boolean isOne(int n, long pos) {
 * if (n == 0) {
 * return true; // n=0일 때는 항상 1
 * }
 * long length = (long) Math.pow(5, n); // n단계에서 비트열의 총 길이
 * long partition = length / 5; // 각 섹션(11011 패턴 또는 00000)의 길이
 * 
 * if (pos < partition * 2) {
 * // 첫 번째 또는 두 번째 11011 패턴에 속함
 * return isOne(n - 1, pos % partition);
 * } else if (pos >= partition * 2 && pos < partition * 3) {
 * // 중간 00000 부분
 * return false;
 * } else {
 * // 마지막 두 11011 패턴 중 하나에 속함
 * return isOne(n - 1, pos % partition);
 * }
 * }
 * }
 * 
 * 
 * 
 */