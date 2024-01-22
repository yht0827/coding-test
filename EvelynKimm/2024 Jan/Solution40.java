class Solution40 {
    public long solution(int w, int h) {
        long answer = 1;

        Long width = Long.valueOf(w);
        Long height = Long.valueOf(h);

        answer = width * height - (width + height - getGreatestNum(width, height));

        return answer;
    }

    long getGreatestNum(long width, long height) {

        long small = height;
        long big = width;

        if (width < height) {
            big = height;
            small = width;
        }

        long temp = 0;

        while (small > 0) {
            temp = big % small;//나누기

            big = small;//8, 4
            small = temp;//4, 0
        }
        return (big);
    }
}