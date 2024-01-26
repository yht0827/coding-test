import java.util.*;


class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Integer[] tmp = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Comparator.reverseOrder()); // 내림차순
        
        for(int i = 0 ; i < tmp.length ; i+=m){
            if(i+m-1 >= tmp.length){
                break;
            }
            int box_score = tmp[i+m-1];
            answer += box_score * m;
        }
        
        
        return answer;
    }
}
