class Solution51 {
    public int solution(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }
}