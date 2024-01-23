import java.util.*;

class Solution45 {
    public int[] solution(int n, String[] words) {
        Map<String, Boolean> map = new HashMap<>();
        int[] answer = {0,0};

        for (int i=0; i<words.length; i++){
            if (i != 0) {
                String last = words[i - 1];
                String now = words[i];

                char tail = last.charAt(last.length() - 1);
                char head = now.charAt(0);

                if (map.containsKey(now) || tail != head) {
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;

                    return answer;
                }
            }
            map.put(words[i],true);
        }
        return answer;
    }
}