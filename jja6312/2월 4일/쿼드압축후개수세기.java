public class Solution {
    private int zeroCount = 0;
    private int oneCount = 0;

    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return new int[] { zeroCount, oneCount };
    }

    private void compress(int[][] arr, int x, int y, int size) {
        if (isUniform(arr, x, y, size)) {
            if (arr[x][y] == 0)
                zeroCount++;
            else
                oneCount++;
        } else {
            int newSize = size / 2;
            compress(arr, x, y, newSize);
            compress(arr, x, y + newSize, newSize);
            compress(arr, x + newSize, y, newSize);
            compress(arr, x + newSize, y + newSize, newSize);
        }
    }

    private boolean isUniform(int[][] arr, int x, int y, int size) {
        int firstValue = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != firstValue)
                    return false;
            }
        }
        return true;
    }

}