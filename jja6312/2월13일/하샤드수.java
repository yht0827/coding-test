import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
            Solution solution = new Solution();

    }
}


class Solution {
    public boolean solution(int x) {
        //x의 자릿수의 합 구하기

        String xString = "" +x;
        int sum=0;
        for(int i=0; i<xString.length(); i++){
            sum+=Integer.parseInt(xString.charAt(i)+"");
        }
        boolean answer = true;
        if(x%sum!=0){
            answer=false;
        }


        return answer;
    }
}