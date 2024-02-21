import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int[] a = new int[10000];
        int[] aExam = new int[]{1,2,3,4,5};
        int[] b = new int[10000];
        int[] bExam = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = new int[10000];
        int[] cExam = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i=0; i<10000; i++){
            a[i]= aExam[i%5];
            b[i] = bExam[i%8];
            c[i] = cExam[i%10];
        }

        int cnt[] = new int[3];

        for(int i=0; i<answers.length; i++){
            if(answers[i]==a[i]) cnt[0]++;
            if(answers[i]==b[i]) cnt[1]++;
            if(answers[i]==c[i]) cnt[2]++;
        }

        int max =0;
        for(int i=0; i<3; i++){
            max = Math.max(max,cnt[i]);
        }


        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<3; i++){
            if(max==cnt[i]){
                list.add(i+1);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}