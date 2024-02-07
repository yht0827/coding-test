import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        StringTokenizer st;
        //ArrayList 로 Map을 담으면됨.(순서를 기억하고, 키값쌍을가지게.)

        //아이디를 바꾸면 Change 맵으로 저장해서, 중복허용X 특징을 이용해 맨 마지막에 덮어씌우게 만든다.


        Map<String, String> changeMap = new HashMap<>();

        ArrayList<String> list = new ArrayList<>(); //들어오고 나가는 것의 순서를 기록

        for (String word : record) {
            st = new StringTokenizer(word, " "); //주어진 매개변수 받고
            String enterOrLeaveOrChange = st.nextToken(); // 첫글자가 뭔지에 따라 다르게분류
            String id = st.nextToken(); //두 번째글자는 id
            String nickName = "";
            if(enterOrLeaveOrChange.equals("Enter") || enterOrLeaveOrChange.equals("Change")) {
                if(st.hasMoreTokens()) { // 닉네임이 있는지 확인
                    nickName = st.nextToken();
                }
            }

            if (enterOrLeaveOrChange.equals("Enter")) { //만약 첫 글자가 엔터라면
                list.add("Enter " + id); //"Enter jja6312"와 같이 들어간다.
                changeMap.put(id, nickName); //id,닉네임을 changeMap에 넣어놓는다.

            } else if (enterOrLeaveOrChange.equals("Leave")) { //Leave라면
                list.add("Leave " + id); //"Leave jja6312"를 넣는다
            } else if (enterOrLeaveOrChange.equals("Change")) { //Change라면

                changeMap.put(id, nickName); //id,닉네임을 changeMap에 넣어놓는다.
            }
        }

        String[] answer = new String[list.size()];
        //그럼 가장 마지막에 바뀐 닉네임이 changeMap에 저장되어 있을 것임.
        for (int i = 0; i < list.size(); i++) {
            st = new StringTokenizer(list.get(i), " "); //list에 "Enter jja6312"같이 저장된거
            String enterOrLeave = st.nextToken(); //첫글자는 Enter 이런거임.
            String id = st.nextToken();//두번째 글자는 id지.
            String nickName = changeMap.get(id); //이제 Map에 저장했던 id:nickName을 꺼낸다. 닉네임나와

            if (enterOrLeave.equals("Enter")) { //첫 글자에 따라, 판독한다.
                answer[i] = (nickName + "님이 들어왔습니다.");
            } else if (enterOrLeave.equals("Leave")) {
                answer[i] = (nickName + "님이 나갔습니다.");
            }

        }//list길이만큼 반복한다.


        return answer;
    }


}
