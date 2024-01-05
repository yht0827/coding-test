/* 문제가 너무 어려워 풀지 못했습니다.
 https://github.com/eona1301/Algorithms-Problem-Solving/blob/main/Programmers/Lv2/118_%5BPCCP%20%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C%5D%203%EB%B2%88%20-%20%EC%95%84%EB%82%A0%EB%A1%9C%EA%B7%B8%20%EC%8B%9C%EA%B3%84.java
 윗분의 깃허브에서 가져온 풀이입니다.*/

class Solution9 {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        int startTime = getSecTime(h1, m1, s1);
        int endTime = getSecTime(h2, m2, s2);

        double[] beforeDeg = getDeg(startTime);
        if (isAllAccord(beforeDeg)) answer++;

        for (int time = startTime + 1;time <= endTime;time++) {
            double[] nowDeg = getDeg(time);

            if (isAllAccord(nowDeg)) {
                beforeDeg = nowDeg;
                answer++;
                continue;
            }

            if (isPass(beforeDeg, nowDeg, 0, 2)) answer++;
            if (isPass(beforeDeg, nowDeg, 1, 2)) answer++;

            beforeDeg = nowDeg;
        }

        return answer;
    }

    public int getSecTime(int h, int m, int s) {
        return h * 60 * 60 + m * 60 + s;
    }

    public boolean isAllAccord(double[] angle) {
        return angle[0] == angle[2] || angle[1] == angle[2];
    }

    public boolean isPass(double[] beforeDeg, double[] nowDeg, int hourOrMin, int sec) {
        return (beforeDeg[sec] < beforeDeg[hourOrMin] && nowDeg[hourOrMin] <= nowDeg[sec]) ||
                (beforeDeg[sec] < beforeDeg[hourOrMin] && nowDeg[sec] == 0);
    }

    public final double HOUR_ANGLE = 30.0 / 60 / 60;
    public final double MIN_ANGLE = 6.0 / 60;
    public final double SEC_ANGLE = 6.0;
    public double[] getDeg(int secTime) {
        return new double[] {(secTime * HOUR_ANGLE) % 360,
                (secTime * MIN_ANGLE) % 360,
                (secTime * SEC_ANGLE) % 360};
    }
}