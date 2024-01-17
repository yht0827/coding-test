//붕대 감기
import java.util.HashMap;
import java.util.Map;

public class solution1 {

    static Map<Integer, Integer> attackInfo = new HashMap<>();
    static int endTime = 0;
    static int curHealth = 0;
    static int successiveTime = 0;

    public int solution(int[] bandage, int health, int[][] attacks) {
        curHealth = health;
        for (int[] attack : attacks) {
            attackInfo.put(attack[0], attack[1]);
            endTime = attack[0];
        }

        /* 1초부터 마지막 공격 시각까지 체력 정보 초기화 */
        for (int i = 1; i <= endTime; i++) {
            if (attackInfo.containsKey(i)) { // 공격이 있다면
                curHealth -= attackInfo.get(i);
                successiveTime = 0;
            } else { // 공격이 없다면
                curHealth += bandage[1];
                successiveTime++;

                if (successiveTime == bandage[0]) {
                    curHealth += bandage[2];
                    successiveTime = 0;
                }
                if (curHealth > health) {
                    curHealth = health;
                }
            }

            if (curHealth <= 0) { // 이번 턴을 마치고 체력이 바닥났다면 종료
                return -1;
            }
        }

        return curHealth;
    }
}