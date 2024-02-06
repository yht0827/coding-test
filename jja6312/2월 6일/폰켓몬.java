import java.util.*;
class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            Set set = new HashSet();
            for(int num : nums){
                set.add(num);
            }
            int maxVariation = set.size();
            if(maxVariation>nums.length/2){
                answer = nums.length/2;
            }else{
                answer = maxVariation;
            }
                    
            
            return answer;
        }
    }