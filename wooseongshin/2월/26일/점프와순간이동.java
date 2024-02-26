public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n!=0){
            ans += (n%2 == 0) ? 0 : 1;
            n = (n%2 == 0) ? n/2 : n-1;
        }
        return ans;
    }
}
