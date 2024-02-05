class Solution {
    public int solution(int n) {
        int answer = 0;

        int next = n + 1;
        while (true) {
            if (Integer.bitCount(next) == Integer.bitCount(n)) {
                answer = next;
                break;
            } else {
                next++;
            }
        }

        return answer;
    }

}

// ----처음엔 아래같이 풀었는데, 훨씬쉬운방법이 있었다.
/*
 * 
 * 
 * import java.io.*;
 * import java.util.*;
 * 
 * public class Main {
 * static BufferedReader br = new BufferedReader(new
 * InputStreamReader(System.in));
 * static BufferedWriter bw = new BufferedWriter(new
 * OutputStreamWriter(System.out));
 * 
 * public static void main(String[] args) throws IOException {
 * Solution solution = new Solution();
 * System.out.println(solution.solution(78));
 * 
 * 
 * 
 * 
 * 
 * }
 * 
 * 
 * }
 * 
 * class Solution {
 * public int solution(int n) {
 * int answer = 0;
 * String ansStr = "";
 * 
 * // 자연수를 101110 과 같은 숫자로 변환시키기.
 * Solution solution = new Solution();
 * String binaryN = solution.convertToBinary(n);
 * 
 * // 두번째자리부터 판독. 만약 모두 1이라면, 두번째자리에 0을추가.
 * int lengthOfBinaryN = binaryN.length();
 * if(binaryN.indexOf("0")==-1){
 * ansStr += "10";
 * for(int i=0; i<lengthOfBinaryN-1; i++){//마지막자리 1 하나더추가시킴.
 * ansStr += "1";
 * }
 * }else{// 모두 1이 아니라면,
 * int whereFirstZeroOne = binaryN.indexOf("01");//0 다음에 1이오는 녀석의 경우
 * ansStr += binaryN.substring(0,whereFirstZeroOne)+"10";
 * // 그리고 나머지 문자열의 길이에, 0000011111처럼 0을 먼저 정렬한다.
 * String lastStr = binaryN.substring(whereFirstZeroOne+2,binaryN.length());
 * //그러기 위해 0의 갯수가 몇개인지 본다.
 * int zeroEA = 0;
 * for(int i=0; i<lastStr.length(); i++){
 * if(lastStr.charAt(i)=='0') zeroEA++;
 * }
 * //0의갯수만큼 먼저 출력시킨다.
 * for(int i=0; i<zeroEA; i++){
 * ansStr += "0";
 * }
 * //그리고 남은 1의갯수를 출력시킨다.
 * for(int i=0; i<lastStr.length()-zeroEA; i++){
 * 
 * ansStr += "1";
 * }
 * 
 * }
 * 
 * answer = solution.convertTen(ansStr);
 * 
 * return answer;
 * }
 * 
 * private int convertTen(String ansStr) {
 * //총 길이에 따라 몇 승인지 판별
 * //1이라면, Math.pow를 그만큼 더하고
 * //0이라면 넘어간다.
 * 
 * 
 * int ans = 0;
 * for(int i=0; i<ansStr.length(); i++){
 * if(ansStr.charAt(i)=='1'){
 * ans += Math.pow(2,ansStr.length()-1-i); //0번째가 총길이-1 승. 마지막번째가 0승.
 * }
 * }
 * 
 * return ans;
 * }
 * public String convertToBinary(int n){
 * int tmpN = n;
 * 
 * // 10승= 1024
 * // 11 2048
 * // 12, 4096
 * //13, 9192
 * // 14, 18384
 * //15 36768
 * //16 73536
 * //17 147072
 * //18 294144
 * //19 588288
 * int pow = 19;
 * StringBuilder sb = new StringBuilder();
 * while(pow>=0){
 * //2의 몇승까지 나눠지는지 보자.
 * if(tmpN<Math.pow(2,pow)){ //만약 숫자가 2의 특정 승보다 작다면, 특정승(pow)값을 줄인다.
 * sb.append("0");
 * pow--;
 * }else if(tmpN>=Math.pow(2,pow)){ //만약 숫자가 2의 특정 승보다 같거나 크면
 * sb.append("1"); //1을 추가하고
 * tmpN -= Math.pow(2,pow); //숫자에 그 만큼을 빼준다.
 * pow--;
 * }
 * }
 * //sb에 00010011001 과 같이 설정되었을 것.
 * //indexOf를통해 1의위치를파악하고, subString으로 잘라준다.
 * String binary = sb.toString();
 * int index = binary.indexOf("1");
 * 
 * return binary.substring(index,binary.length());
 * 
 * }
 * 
 * }
 * 
 */