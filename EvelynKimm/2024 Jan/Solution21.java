import java.util.Arrays;
import java.util.HashSet;

class Solution21 {
    public int[] solution(String s) {
        String [] strs = s.replaceAll("[{}]", " ")
                .trim()
                .split(" ,");

        int[] answer = new int[strs.length];

        HashSet<Integer> hs = new HashSet<Integer>();

        Arrays.sort(strs, (a, b)->(a.length()-b.length()));
        int i = 0;

        for(String str : strs){
            for(String st : str.split(",")){
                int a  = Integer.parseInt(st.trim());

                if (hs.contains(a)) {
                    continue;
                }

                hs.add(a);
                answer[i++] = a;
            }
        }
        return answer;
    }
}