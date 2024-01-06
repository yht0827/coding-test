// 택배배달과 수거하기
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        //트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리를 return

        int d = 0;
        int p = 0;
        for(int i=n-1; i>=0; i--){
            d -= deliveries[i];
            p -= pickups[i];

            while(d < 0 || p < 0){
                d += cap;
                p += cap;
                answer += (i+1)*2;
            }
        }

        return answer;
    }
}