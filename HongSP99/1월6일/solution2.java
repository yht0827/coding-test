import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> d = new Stack<>();
        Stack<Integer> p = new Stack<>();
        int box = 0;

        for(int i = 0; i < n; i ++){
            d.push(deliveries[i]);
            p.push(pickups[i]);
        }

        while (!d.empty() && d.peek() == 0) 
            d.pop();
        while (!p.empty() && p.peek() == 0) 
            p.pop();

        while(!d.isEmpty() || !p.isEmpty()){
            answer += Math.max(d.size() * 2, p.size() * 2);

            box = 0;
            while(!d.isEmpty() && box <= cap){
                if(d.peek() + box <= cap){
                    box += d.peek();
                }else{
                    d.push(d.pop() - (cap - box));
                    break;
                }
                d.pop();
            }

            box = 0;
            while(!p.isEmpty() && box <= cap){
                if(p.peek() + box <= cap){
                    box += p.peek();
                }else{
                    p.push(p.pop() - (cap - box));
                    break;
                }
                p.pop();
            }
        }

        return answer;
    }
}
