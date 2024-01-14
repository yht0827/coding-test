import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for(int i = left ; i <= right ; i++){
            int count = cnt_divisor(i);
            if(count%2 == 0){
                even.add(i);
            } else {
                odd.add(i);
            }
        }

        for(int i = 0 ; i < even.size() ; i++){
            answer += even.get(i);
        }

        for(int i = 0 ; i < odd.size() ; i++){
            answer -= odd.get(i);
        }

        return answer;
    }

    public int cnt_divisor(int number){
        int count = 0;
        for(int i = 1 ; i <= number ; i++){
            if(number%i == 0){
                count++;
            }
        }
        return count;
    }
}

//다른사람의 풀이
//제곱수라면 약수의 개수가 홀수라는 것을 이용
//제곱수를 구하는 코드 : number % Math.sqrt(number) == 0
class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i=left;i<=right;i++) {
            //제곱수인 경우 약수의 개수가 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            //제곱수가 아닌 경우 약수의 개수가 짝수
            else {
                answer += i;
            }
        }

        return answer;
    }
}
