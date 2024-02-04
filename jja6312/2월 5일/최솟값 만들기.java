import java.io.*;
import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;

        ArrayList<Integer> aArr = new ArrayList<>();
        ArrayList<Integer> bArr = new ArrayList<>();

        for(int i=0; i<A.length; i++){
            aArr.add(A[i]);
            bArr.add(B[i]);
        }

        Collections.sort(aArr);
        Collections.sort(bArr);

        for(int i=0; i<aArr.size(); i++){
            answer += aArr.get(i) * bArr.get(bArr.size()-1-i);
        }


        return answer;
    }
}