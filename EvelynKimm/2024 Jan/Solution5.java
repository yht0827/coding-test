import java.util.HashMap;
import java.util.Map;

class Solution5 {
    public int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int[targets.length];

        Map<Character, Integer> map = new HashMap<>();

        for (String str : keymap) {
            for(int i=0; i<str.length(); i++) {
                char key = str.charAt(i);
                map.put(key, Math.min(i + 1, map.getOrDefault(key, 101)));
            }
        }

        for (int i=0; i< targets.length; i++) {
            String str = targets[i];
            for (int j=0; j<str.length(); j++) {
                char key = str.charAt(j);
                if (map.containsKey(key)) {
                    answer[i] += map.get(key);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}