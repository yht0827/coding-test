import java.util.*;

class Solution12 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Stack<Integer> D = new Stack<>();
        Stack<Integer> P = new Stack<>();
        long answer = 0;

        for(int i=0; i<n; i++){
            D.push(deliveries[i]);
            P.push(pickups[i]);
        }

        while(!D.isEmpty() || !P.isEmpty()){

            while(!D.isEmpty() && D.peek() == 0){
                D.pop();
            }
            while(!P.isEmpty() && P.peek() == 0){
                P.pop();
            }

            answer += 2*Math.max(D.size(), P.size());

            int Dtarget = 0;
            while(!D.isEmpty()){
                int Dcurrent = D.pop();

                if(Dtarget + Dcurrent <= cap){
                    Dtarget += Dcurrent;
                }else{
                    D.push(Dtarget + Dcurrent - cap);
                    break;
                }
            }

            int Ptarget = 0;
            while(!P.isEmpty()){
                int Pcurrent = P.pop();

                if(Ptarget + Pcurrent <= cap){
                    Ptarget += Pcurrent;
                }else{
                    P.push(Ptarget + Pcurrent - cap);
                    break;
                }
            }
        }
        return answer;
    }
}