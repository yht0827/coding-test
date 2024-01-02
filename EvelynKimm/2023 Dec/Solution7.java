class Solution7 {
    private static final int MAX_TIME = 1450;
    private static final int HOUR = 60;
    private static final int CLEAN_TIME = 10;

    public int solution(String[][] book_time) {
        int answer = 0;

        int[] rooms = new int[MAX_TIME];

        for (String[] time : book_time) {
            String inTime = time[0];
            String outTime = time[1];

            rooms[calTime(inTime)] += 1; // 입실시간
            rooms[calTime(outTime) + CLEAN_TIME] += -1;
        }

        for (int i=1; i<MAX_TIME; i++) {
            rooms[i] += rooms[i-1];
            answer = Math.max(answer, rooms[i]);
        }
        return answer;
    }

    private static int calTime(String time) {
        String[] split = time.split(":");
        String hour = split[0];
        String minute = split[1];

        return ((Integer.parseInt(hour) * HOUR) + Integer.parseInt(minute));

    }

}