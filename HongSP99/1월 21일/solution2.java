import java.util.*;

class Solution {
    public long solution(long w, long h) {
        long answer = 1;

        long gcd = gcd(w, h);

        answer = (w*h) - ((w/gcd + h/gcd - 1) * gcd);

        return answer;
    }

    public long gcd(long w, long h){
        long gcd = 0;
        List<Long> findGCD = new ArrayList<>();
        for(long i = 1 ; i <= Math.sqrt(w) ; i++){
            if(i*i == w){
                findGCD.add(i);
            }
            else if(w % i == 0){
                findGCD.add(i);
                findGCD.add(w/i);
            }
        }

        for(int i = findGCD.size()-1 ; i >=0 ; i--){
            if(h % findGCD.get(i) == 0){
                gcd = Math.max(gcd, findGCD.get(i));
            }
        }

        return gcd;
    }
}
