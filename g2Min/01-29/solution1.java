// 없는 숫자 더하기

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] temp=new boolean[10];
        for(int i=0;i<10;i++){
            temp[i]=false;
        }
        for(int i=0;i<numbers.length;i++){
            if(!temp[numbers[i]]){
                temp[numbers[i]]=true;
            }
        }

        for(int i=0;i<temp.length;i++){
            if(!temp[i]){
                answer+=i;
            }
        }
        return answer;
    }
}