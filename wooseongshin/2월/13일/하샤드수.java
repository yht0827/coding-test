import java.util.Arrays;
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sumx= 0;
        int n=x;
        while(x!=0){
            sumx+= (x%10);
            x /=10;
        }
        if((n%sumx)==0){
            answer = true;
        }
        else{
            answer = false;
        }


        return answer;
    }
}
