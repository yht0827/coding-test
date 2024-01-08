import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        HashMap<String, Integer> resultMap = new HashMap<>();

        HashSet<String> hashSet = new HashSet<>(Arrays.asList(report));

        report = hashSet.toArray(new String[hashSet.size()]);
        int[] answer = new int[id_list.length];


        for(int i=0; i < report.length; i++){

            if(resultMap.containsKey(report[i].split(" ")[1])){

                resultMap.put(report[i].split(" ")[1], resultMap.get(report[i].split(" ")[1]) + 1);
            } else {

                resultMap.put(report[i].split(" ")[1], 1);
            }
        }

        for (int i=0; i < report.length; i++){
            String[] tmp_r = report[i].split(" ");
            if(resultMap.getOrDefault(tmp_r[1], 0) >= k){
                answer[Arrays.asList(id_list).indexOf(tmp_r[0])] = answer[Arrays.asList(id_list).indexOf(tmp_r[0])] + 1;
            }
        }
        //int[] result = answer.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
