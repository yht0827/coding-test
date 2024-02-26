import java.util.Arrays;
class Solution {
    public String solution(String phone_number) {

        char[] charArray = phone_number.toCharArray();
        for(int i=0; i<(charArray.length-4); i++){
            charArray[i]= '*';
        }
        String answer = new String(charArray);

        return answer;
    }
}
