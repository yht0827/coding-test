import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int answer = set.size();
        if(answer > nums.length / 2) {
            answer = nums.length / 2;
        }

        return answer;
    }
}
