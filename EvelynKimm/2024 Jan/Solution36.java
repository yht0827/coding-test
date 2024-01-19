import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution36 {
    public int solution(int k, int[] tangerine) {
        int sum = 0;
        int cnt = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        ArrayList<Integer> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList, Collections.reverseOrder());

        for (int v : valueList) {
            if (sum + v >= k) {
                cnt++;
                break;
            } else {
                sum += v;
                cnt++;
            }
        }
        return cnt;
    }
}