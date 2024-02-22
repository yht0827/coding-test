class Solution {
    public String solution(int a, int b) {
        int[] arr = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        // a-1는 index. 그 index 전까지 숫자들을 다 더한다.
        // 그리고 b를 더한다.
        // 그리고 1일 때 금요일이라는점을 참고해서 결론을 도출한다.
        String[] dayArr = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };

        int sum = 0;
        for (int i = 0; i < a - 1; i++) {
            sum += arr[i];
        }
        sum += b;
        sum -= 1;// 0번째 일 때 금요일이어야한다. 하지만
        int index = sum % 7;
        String answer = dayArr[index];

        return answer;
    }
}