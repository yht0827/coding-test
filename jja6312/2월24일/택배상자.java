import java.util.Stack;

public class Solution {
    public int solution(int[] order) {
        Stack<Integer> auxiliaryBelt = new Stack<>();
        int count = 0; // 실은 상자의 수
        int mainBeltIndex = 0; // 메인 컨테이너 벨트의 현재 인덱스
        for (int i = 0; i < order.length; i++) {
            // 메인 컨테이너 벨트에서 필요한 상자를 찾아서 보조 컨테이너 벨트로 이동
            while (mainBeltIndex < order.length && mainBeltIndex + 1 <= order[i]) {
                auxiliaryBelt.push(++mainBeltIndex);
            }

            // 보조 컨테이너 벨트의 상단에 있는 상자가 현재 실어야 하는 상자인지 확인
            if (!auxiliaryBelt.isEmpty() && auxiliaryBelt.peek() == order[i]) {
                auxiliaryBelt.pop(); // 상자를 트럭에 싣고, 보조 벨트에서 제거
                count++; // 실은 상자 수 증가
            } else {
                // 원하는 순서의 상자를 실을 수 없는 경우
                break;
            }
        }
        return count;
    }
}
