class Solution {
    public int[] solution(long n) {
        String str = ""+n;
        int[] answer = new int[str.length()];
        for(int i=str.length()-1; i>=0; i--){
            answer[str.length()-1-i]=Integer.parseInt(""+str.charAt(i));
        }


        
        return answer;
    }
}