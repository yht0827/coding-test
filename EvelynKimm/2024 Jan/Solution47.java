import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution47 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};

        Map<String, Integer> columnOrder = new HashMap<>();
        columnOrder.put("code", 0);
        columnOrder.put("date", 1);
        columnOrder.put("maximum", 2);
        columnOrder.put("remain", 3);

        answer = Arrays.stream(data)
                .filter(x -> x[columnOrder.get(ext)] < val_ext)
                .toArray(int[][]::new);;
        Arrays.sort(answer, (o1, o2) ->  o1[columnOrder.get(sort_by)] - o2[columnOrder.get(sort_by)]);


        return answer;
    }
}