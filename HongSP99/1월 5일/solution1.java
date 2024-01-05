class Solution {

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int start = h1 * 60 + m1;
        int end = h2 * 60 + m2;
        int answer = 0;

        for (int i = start; i <= end; i++) {
            if (i == 719 || i == 1439) {
                continue;
            }
            if (start == end) {
                if ((i == 0 || i == 720) && s1 == 0) {
                    answer = 1;
                    break;
                }
                double startAng = (double) s1 / 60;
                double endAng = (double) s2 / 60;
                double hourAng = getAng(toSec(h1,m1,s1), true);
                double minAng = getAng(toSec(h1,m1,s1), false);
                if (hourAng >= startAng && hourAng <= endAng) {
                    answer++;
                }
                if (minAng >= startAng && minAng <= endAng) {
                    answer++;
                }
            } else if (i == start) {
                if ((i == 0 || i == 720) && s1 == 0) {
                    answer++;
                    continue;
                }
                double startAng = (double) s1 / 60;
                if (getAng(toSec(h1,m1,s1), true) >= startAng) {
                    answer++;
                }
                if (i % 60 != 59 && getAng(toSec(h1,m1,s1), false) >= startAng) {
                    answer++;
                }
            } else if (i == end) {
                if (i == 720) {
                    answer++;
                    break;
                }
                double endAng = (double) s2 / 60;
                if (endAng >= getAng(toSec(h2,m2,s2), true)) {
                    answer++;
                }
                if (endAng >= getAng(toSec(h2,m2,s2), false)) {
                    answer++;
                }
            } else if (i % 60 != 59) {
                answer += (i == 720) ? 1 :  2;
            } else {
                answer++;
            }
        }
        return answer;
    }

    public int toSec(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

    public double getAng(int s, boolean isHour) {
        if (isHour) {
            s %= 43200;
            return (double) s / 43200;
        }
        s %= 3600;
        return (double) s / 3600;
    }

}
