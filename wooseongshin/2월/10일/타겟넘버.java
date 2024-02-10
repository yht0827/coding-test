class Solution {
    public static int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(0,numbers,target,0);

        return cnt;

    }

    public void dfs(int depth,int[] numbers,int target,int result){
        if (depth == numbers.length){
            if(target == result){
                cnt+=1;
            }
            return;
        }
        int add = result + numbers[depth];
        int sub = result - numbers[depth];

        dfs(depth+1,numbers,target,add);
        dfs(depth+1,numbers,target,sub);

    }

}
