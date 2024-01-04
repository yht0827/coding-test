class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for(int i = 0; i < targets.length; i++){            
            for(char ct : targets[i].toCharArray()){
                int tempIdx = 9999;
                boolean chkIn = false;
                for(String k : keymap){
                    int chkIndex = k.indexOf(ct);
                    if(chkIndex > -1){                        
                        tempIdx = tempIdx > chkIndex ? chkIndex : tempIdx;
                        chkIn = true;
                    }
                }                
                if(chkIn)
                    answer[i] += tempIdx + 1;
                else
                    answer[i] = -1;
            }
        }

        return answer;
    }
}
