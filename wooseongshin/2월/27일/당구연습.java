class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int[] arr = new int[4];

        for(int i = 0; i < balls.length; i++){
            if(startY == balls[i][1]){
                answer[i] = calculateDistanceForSameY(m, startX, startY, balls[i]);
            } else if(startX == balls[i][0]){
                answer[i] = calculateDistanceForSameX(n, startX, startY, balls[i]);
            } else {
                answer[i] = calculateDistanceForDifferentXY(m, n, startX, startY, balls[i]);
            }
        }
        return answer;
    }

    private int calculateDistanceForSameY(int m, int startX, int startY, int[] ball) {
        int minY = Math.min(m - startY, startY);
        int arr0 = (int) Math.pow(ball[0] - startX , 2) + (int) Math.pow(minY * 2, 2);
        int arr1 = startX < ball[0] ? (int) Math.pow(startX + ball[0], 2) : (int) Math.pow(m - startX + m - ball[0], 2);
        return Math.min(arr0, arr1);
    }

    private int calculateDistanceForSameX(int n, int startX, int startY, int[] ball) {
        int minX = Math.min(n - startX, startX);
        int arr0 = (int) Math.pow(minX * 2, 2) + (int) Math.pow(ball[1] - startY, 2);
        int arr1 = startY < ball[1] ? (int) Math.pow(startY + ball[1], 2) : (int) Math.pow(n - startY + n - ball[1], 2);
        return Math.min(arr0, arr1);
    }

    private int calculateDistanceForDifferentXY(int m, int n, int startX, int startY, int[] ball) {
        int[] arr = new int[4];
        arr[0] = (int) Math.pow( m + (m - startX) - ball[0], 2) + (int) Math.pow(ball[1] - startY, 2);
        arr[1] = (int) Math.pow(startX + ball[0], 2) + (int) Math.pow(ball[1] - startY, 2);
        arr[2] = (int) Math.pow( n + (n - startY) - ball[1], 2) + (int) Math.pow(ball[0] - startX, 2);
        arr[3] = (int) Math.pow(startY + ball[1] , 2)+ (int) Math.pow(ball[0] - startX, 2);
        int min = arr[0];
        for(int j = 1; j < 4; j++){
            if(min > arr[j]){
                min = arr[j];
            }
        }
        return min;
    }
}
