import java.util.*;

class Solution22 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int INF = 23 * 60 + 59;
        Map<Integer, Integer> startTime = new HashMap<>();
        Map<Integer, Integer> totalTime = new HashMap<>();
        Set<Integer> carSet = new HashSet<>();

        for (String s : records) {
            String[] str = s.split(" ");
            String[] times = str[0].split(":");
            int min = (Integer.parseInt(times[0]) * 60) + Integer.parseInt(times[1]);
            int num = Integer.parseInt(str[1]);
            if (!startTime.containsKey(num)) {
                carSet.add(num);
                startTime.put(num, min);
                if (!totalTime.containsKey(num)) {
                    totalTime.put(num, 0);
                }
            } else {
                totalTime.put(num, totalTime.get(num) + min - startTime.get(num));
                startTime.remove(num);
            }
        }

        for (Integer key : startTime.keySet()) {
            totalTime.put(key, totalTime.get(key) + INF - startTime.get(key));
        }

        List<Integer> list = new ArrayList<>(carSet);
        Collections.sort(list);
        answer = new int[carSet.size()];
        int idx = 0;
        for (int num : list) {
            int time = totalTime.get(num);
            if (time <= fees[0]) {
                answer[idx] = fees[1];
            } else {
                answer[idx] = (int) (fees[1] + Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3]);
            }
            idx++;
        }

        return answer;
    }
}