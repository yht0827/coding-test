import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 한 번호가 다른 번호의 접두어인가?
        // 만약 indexOf 했을 때 -1이 나온다면? 접두어가 없다. => indexOf가 아닌 startWith이 정답을충족했다.
        // 만약 아니라면 접두어가 있다.
        Arrays.sort(phone_book);
        boolean answer = true;
        for (int i = 0; i < phone_book.length - 1; i++) {
            String thisWord = phone_book[i];
            String nextWord = phone_book[i + 1];
            if (nextWord.startsWith(thisWord)) {
                answer = false;
                break;
            }

        } // for1

        return answer;
    }
}