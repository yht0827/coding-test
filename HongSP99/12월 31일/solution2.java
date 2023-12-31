import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String,Integer> m=new HashMap<>();
        m.put("R",0); m.put("T",0); m.put("C",0); m.put("F",0);
        m.put("J",0); m.put("M",0); m.put("A",0); m.put("N",0);
        for(int i=0; i<survey.length; i++) {
            String s=survey[i];
            if(choices[i] < 4){
                m.put(Character.toString(s.charAt(0)),m.get(Character.toString(s.charAt(0)))+4-choices[i]);
            }
            else if(choices[i] > 4){
                m.put(Character.toString(s.charAt(1)),m.get(Character.toString(s.charAt(1)))+choices[i]-4);
            }
        }

        // 각 지표끼리 비교
        String answer="";
        if(m.get("R") >= m.get("T")) answer+="R";
        else answer+="T";
        if(m.get("C") >= m.get("F")) answer+="C";
        else answer+="F";
        if(m.get("J") >= m.get("M")) answer+="J";
        else answer+="M";
        if(m.get("A") >= m.get("N")) answer+="A";
        else answer+="N";

        return answer;
    }
}
