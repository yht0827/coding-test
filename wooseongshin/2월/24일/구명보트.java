import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {

        int answer = 0;

        Arrays.sort(people);
        int left = 0;

        for(int right=people.length - 1; left <= right;right--){
            if(people[left]+people[right] <= limit) left++;
            answer++;
        }
        return answer;
    }
}
