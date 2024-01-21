class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for(int i = 0 ; i < babbling.length ; i++){
            int nextIndex = 1;
            String beforeBabyTalk = "";
            String talk = babbling[i].substring(0, nextIndex);
            //발음할 수 있는 String의 length가 무조건 2이상이므로
            while(nextIndex < babbling[i].length()){ 
                //String은 class이므로 length()를 해야된다!
                talk += babbling[i].substring(nextIndex, ++nextIndex);
                if(babyTalk(beforeBabyTalk, talk)){
                    beforeBabyTalk = talk;
                    talk = "";
                }
            }
            if(talk.equals("")){
                answer++;
            }
        }

        return answer;
    }

    public boolean babyTalk(String beforeBabyTalk, String talk){
        if(talk.equals("aya") && !beforeBabyTalk.equals("aya")){
            return true;
        }
        if(talk.equals("ye") && !beforeBabyTalk.equals("ye")){
            return true;
        }
        if(talk.equals("woo") && !beforeBabyTalk.equals("woo")){
            return true;
        }
        if(talk.equals("ma") && !beforeBabyTalk.equals("ma")){
            return true;
        }
        return false;
    }
}
