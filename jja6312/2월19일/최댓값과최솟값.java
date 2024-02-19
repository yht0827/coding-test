import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        StringTokenizer st = new StringTokenizer(s, " ");
        ArrayList<Integer> list = new ArrayList<>();

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        answer += list.get(0) + " " + list.get(list.size() - 1);

        return answer;
    }
}