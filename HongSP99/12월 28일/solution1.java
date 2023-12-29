// 오답
//i/3과 i/2와 i-n이 모두 만족하는 식이면 계속해서 1을 더해 오답이 나온다.
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[y+1];

        prepare(dp, x, y, n);
        
        return dp[y];
    }
    
    public void prepare(int[] dp, int x, int y, int n){
        //초깃값 설정
        for(int i = 0 ; i < dp.length ; i++){
            dp[i] = -1;
        }
        
        dp[x] = 0;
        
        //점화식 구하기
        for(int i = x ; i <= y ; i++){
            if(i/3 == 0 && dp[i/3] != -1) dp[i] = dp[i/3]+1;
            if(i/2 == 0 && dp[i/2] != -1) dp[i] = dp[i/2]+1;
            if(i - n >= 0 && dp[i-n] != -1) dp[i] = dp[i-n] + 1;
        }
    }
}

//우수 정답
//Math.min을 통해 내가 처리한 오답을 막을 수 있다.
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[y+1];

        for(int i=x;i<=y;i++){
            if(i!=x && dp[i]==0) dp[i]=-1;
            else{
                if(i*3<=y) dp[i*3] = dp[i*3]==0 ? dp[i]+1 : Math.min(dp[i*3], dp[i]+1);
            
                if(i*2<=y) dp[i*2] = dp[i*2]==0 ? dp[i]+1 : Math.min(dp[i*2], dp[i]+1);
            
                if(i+n<=y) dp[i+n] = dp[i+n]==0 ? dp[i]+1 : Math.min(dp[i+n], dp[i]+1);
            }

        }
        return dp[y];
    }
}
