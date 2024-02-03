class Solution {
    public int solution(int n, long start, long end) {
        return countOnes(n, start, end, 1);
    }

    public int countOnes(int n, long start, long end, long index) {
        if(n == 0) {
            return 1;
        }
        int totalOnes = 0;
        long partition = (long)Math.pow(5, n - 1);
        for(int i = 0; i < 5; i++) {
            long partitionStart = index + partition * i;
            long partitionEnd = index + partition * (i + 1) - 1;
            if(i == 2 || end < partitionStart || partitionEnd < start) continue;
            totalOnes += countOnes(n - 1, start, end, partitionStart);
        }
        return totalOnes;
    }
}
