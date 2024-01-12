//solution1을 적용해봄.
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int max_rank = 0;
        int min_rank = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int lotto : lottos) hm.put(lotto, hm.getOrDefault(lotto, 0) + 1);
        for(int nums : win_nums) hm.put(nums, hm.getOrDefault(nums, 0) - 1);
        
        
        for(int lotto : hm.keySet()){
            if(lotto == 0){
                for(int i = 0 ; i < hm.get(lotto) ; i++){
                    max_rank++;
                }
            } else if(hm.get(lotto) == 0){
                min_rank++;
                max_rank++;
            }
        }
        
        answer[0] = Math.min(7-max_rank, 6);
        answer[1] = Math.min(7-min_rank, 6);
        
        return answer;
    }
}
