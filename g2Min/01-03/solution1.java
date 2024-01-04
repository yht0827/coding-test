// 대충 만든 자판
import java.util.*;

class solution1 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();

        // keymap 위 모든 알파벳의 최소 클릭 수 구하기
        for(int i=0;i<keymap.length;i++){


            // 최소 클릭수로 덮어씌우기 위해 문자열 끝부터 시작
            for(int j=0;j<keymap[i].length();j++){


                if (map.containsKey(keymap[i].charAt(j))) {
                    // 최소 클릭 수가 뒤에 나왔을 때 갱신
                    Integer nCurrCnt = map.get(keymap[i].charAt(j));
                    if (nCurrCnt > (j+1)){
                        map.put(keymap[i].charAt(j),j+1);
                    }
                }
                else {
                    map.put(keymap[i].charAt(j),j+1);
                }

            }
        }

        // 모든 targets 단어에 대해 반복
        for(int i=0;i<targets.length;i++){
            int nCnt = 0;
            for(int j=0;j<targets[i].length();j++){
                char alpha = (targets[i].charAt(j));
                Integer nMinClick = map.get(alpha);
                if ( nMinClick != null ) {
                    nCnt += nMinClick;
                }
                else{
                    nCnt = -1;  // i번째 단어는 작성할 수 없음
                    break;
                }
            }
            answer[i] = nCnt;

        }
        return answer;
    }
}