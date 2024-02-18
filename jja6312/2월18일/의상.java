import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        // 옷을 종류별로 분류하여 개수를 센다.
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 각 옷 종류별로 입거나 입지 않는 경우의 수를 계산한다. (옷의 개수 + 1)
        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1);
        }

        // 아무것도 입지 않는 경우의 수 1을 뺀다.
        return answer - 1;
    }
}
