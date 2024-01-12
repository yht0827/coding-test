//완주하지 못한 선수
public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant); //이름 순으로 정렬
        Arrays.sort(completion); // 이름 순으로 정렬

        //참가자와 완주자의 이름을 비교해서 다르면, 완주를 못한 사람이기 때문에 그 값을 return
        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        
        //완주자를 끝까지 비교했는데, 다른 이름이 없다면 참가자의 마지막사람이 미완주자
        return participant[participant.length-1];
}