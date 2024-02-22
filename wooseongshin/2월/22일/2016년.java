class Solution{
    public String solution(int a, int b) {
        String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] last_day = {-1, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int m = 1, d = 1;
        int i = 5;

        while (m != 13) {
            if (d > last_day[m]) {
                d = 1;
                m += 1;
            }
            if (a == m && b == d) {
                break;
            }
            i = (i + 1) % 7;
            d += 1;
        }
        return week[i];
    }
}
