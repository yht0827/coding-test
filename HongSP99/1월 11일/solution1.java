import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer;
        ArrayList<String> sList = new ArrayList<>();
        ArrayList<String> answerList = new ArrayList<>();
        StringTokenizer divS = new StringTokenizer(s,"{}");

        while(divS.hasMoreTokens()) {
            String tempString = divS.nextToken();
            if(!tempString.equals(","))
                sList.add(tempString);
        }

        Collections.sort(sList, (o1, o2) -> {return Integer.compare(o1.length(),o2.length());});
        answerList.add(sList.get(0));

        for(int i = 1; i < sList.size(); i++){
            String[] tempChar = sList.get(i).split(",");
            for(int j = 0; j < tempChar.length; j++) {
                if (!answerList.contains(tempChar[j]))
                    answerList.add(tempChar[j]);
            }
        }

        return answerList.stream().mapToInt(Integer::parseInt).toArray();
    }
}
