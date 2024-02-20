class Solution {

    public int solution(int n, int a, int b) {
        int aTeam = a;
        int bTeam = b;
        int cnt = 0;
        int answer = 0;

        // 1,3이라고치면
        // 1,2번째 팀에 속하고
        // 두번째라운드에서
        // 1,2번 으로 만난다.

        // 4,13 이라고 치면
        // 2,7팀 이고 --1라운드
        // 1,4팀 이고 --2라운드
        // 1,2팀 이고 --3라운드
        // --4라운드에서 만난다.

        // 현재 몇 팀인지 확인하는 로직을 만들고
        // 팀이 같아지면, 같아질때까지 세아린 cnt를 answer로 출력하자.
        while (aTeam != bTeam) {
            if (aTeam % 2 == 0) {// 짝수면
                aTeam = aTeam / 2;
            } else {// 홀수면
                aTeam = aTeam / 2 + 1;
            }

            if (bTeam % 2 == 0) {
                bTeam = bTeam / 2;
            } else {
                bTeam = bTeam / 2 + 1;
            }

            cnt++;

        }

        answer = cnt;

        return answer;
    }
}