import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        Deque<Character> dq = new LinkedList<>();
        Deque<Character> newDq = new LinkedList<>();

        //1. 모든 대문자를 소문자로 치환 
        String str = new_id.toLowerCase();
        //2. 알파벳 소문자, 숫자, _ _ . 남기기
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                dq.offer(ch);
            }
            else if ('0' <= ch && ch<='9'){
                dq.offer(ch);
            }
            else if (ch == '-'|| ch =='_' || ch == '.'){
                dq.offer(ch);
            }
        }        
        //3단계 new_id에서 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
        char prev = dq.poll();
        newDq.offer(prev);

        while (!dq.isEmpty()){
            char ch = dq.poll();
            if(ch == '.' && ch == prev){
                continue;
            }
            else{
                newDq.offer(ch);
            }
        prev = ch;
        }
        //4단계
        if (newDq.size() == 1){
            if(newDq.peekFirst() == '.'){
                newDq.pollFirst();
            }
        }
        else if(newDq.size() >= 1){
            if(newDq.peekFirst() == '.'){
                newDq.pollFirst();
            }
            if(newDq.peekLast() == '.'){
                newDq.pollLast();
            }
        }

        //5단계
        if(newDq.size() == 0){
            newDq.offer('a');
        }
        //6단계
        if(newDq.size() >= 16){
            while(newDq.size() != 15){
                newDq.pollLast();
            }
            if(newDq.peekLast() == '.'){
                newDq.pollLast();
            }
        }
        //7단계
        if(newDq.size() <= 2){
            while(newDq.size() != 3){
                char ch = newDq.peekLast();
                newDq.offer(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!newDq.isEmpty()){
            sb.append(newDq.poll());
        }
        answer = sb.toString();
        return answer;
    }
}
