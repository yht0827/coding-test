import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        //특정 숫자 이상인 숫자가 특정 숫자만큼 있는지를 찾으면됨.

        Arrays.sort(citations);

        int maxH=0;
        for(int i=0; i<citations.length; i++){
            int h = Math.min(citations[i], citations.length-i);
            maxH = Math.max(maxH,h);
        }

        int answer = maxH;

        return answer;
    }
}