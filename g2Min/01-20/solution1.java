//옹알이

import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int ans = 0;

        for (int i=0; i<babbling.length; i++){
            babbling[i] = babbling[i].replace("ayaaya", "1");
            babbling[i] = babbling[i].replace("yeye", "1");
            babbling[i] = babbling[i].replace("woowoo", "1");
            babbling[i] = babbling[i].replace("mama", "1");


            babbling[i] = babbling[i].replace("aya", " ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ma", " ");

            babbling[i] = babbling[i].replace(" ","");


            if(babbling[i].length() == 0){
                ans++;
            }
        }

        return ans;
    }
}