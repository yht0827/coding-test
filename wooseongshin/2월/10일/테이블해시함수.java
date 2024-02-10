import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        //2
        sortArray(data, col);
        //3
        List<Integer> remainderSums = calculateRemainderSums(data, row_begin, row_end);
        //4
        int answer = performXOR(remainderSums);
        return answer;
    }

    private void sortArray(int[][] data, int col) {
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col - 1] != o2[col - 1]) {
                return o1[col - 1] - o2[col - 1];
            } else {
                return o2[0] - o1[0];
            }
        });
    }

    private List<Integer> calculateRemainderSums(int[][] data, int row_begin, int row_end) {
        List<Integer> list = new ArrayList<>();
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int temp = 0;
            for (int j = 0; j < data[i].length; j++) {
                temp += data[i][j] % (i + 1);
            }
            list.add(temp);
        }
        return list;
    }

    private int performXOR(List<Integer> list) {
        int result = 0;
        for (int i : list) {
            result ^= i;
        }
        return result;
    }
}
