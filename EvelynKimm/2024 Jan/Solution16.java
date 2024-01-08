import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution16 {
    public int[] solution(String[] id_list, String[] report, int k) {

        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> reportCountMap = new HashMap<>();
        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            map.put(name, new HashSet<>());
            reportCountMap.put(name, i);
        }

        for (String str : report) {
            String reporter = str.split(" ")[0];
            String respondent = str.split(" ")[1];
            map.get(respondent).add(reporter);
        }

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> sendMail = map.get(id_list[i]);
            if (sendMail.size() >= k) {
                for (String name : sendMail) {
                    answer[reportCountMap.get(name)]++;
                }
            }
        }
        return answer;
    }
}