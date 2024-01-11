
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Set<Integer> numberSet = new HashSet<>();//차량번호들 저장
        int[] sum = new int[10000];//차량별 누적 주차시간
        Map<Integer,Integer> mid = new HashMap<>();//누적 중간 계산

        //기록 읽기
        for(String s:records){
            //시간 읽고 잘라서 분으로 계산
            String t=s.split(" ")[0];
            int time = Integer.parseInt(t.split(":")[0])*60+Integer.parseInt(t.split(":")[1]);
            //차량번호 읽기
            int num=Integer.parseInt(s.split(" ")[1]);
            //차량번호 중복없이 저장
            numberSet.add(num);
            //입출입 현황
            String io=s.split(" ")[2];
            if(io.equals("IN"))//입차면 중간 시간 계산에 이용할 map에 (차량,주차시작시간) 넣기
                mid.put(num,time);
            else{//출차면 중간 시간 계산 0으로 하고 차량번호에 누적 시간 넣기
                sum[num]+=time-mid.get(num);
                mid.put(num,-1);
            }
        }

        int[] answer = new int[numberSet.size()];

        //나가지 않고 들어오기만 한 차량 주차 시간 계산(12:59-입차시간) 후 주차시간 누적 
        Iterator<Integer> it = mid.keySet().iterator();
        while(it.hasNext()){
            int num=it.next();
            int t=mid.get(num);
            if(t!=-1)
                sum[num]+=23*60+59-t;
        }

        //차량번호 오름차순
        List<Integer> number = new ArrayList<>(numberSet);
        Collections.sort(number);

        //요금 계산
        for(int i=0;i<number.size();i++){
            answer[i] = fees[1];//기본 요금
            int m = sum[number.get(i)]-fees[0];//누적시간 - 기본시간
            if(m>0){//누적시간이 기본시간보다 크면 기본요금 + a
                answer[i]+=(m/fees[2])*fees[3];
                if(m%fees[2]!=0)    answer[i]+=fees[3];
            }
        }

        return answer;
    }
}
