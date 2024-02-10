class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target , 0,0);


        return answer;
    }

    private void dfs(int[] numbers, int target, int index, int sum){
        if(index == numbers.length){
            if(sum== target){
                answer++;
            }
            return;
        }//만약 numbers 배열 길이 끝에 도달하면 return.

        //현재 숫자를 더하는 경우
        dfs(numbers, target, index + 1, sum + numbers[index]);

        //현재 숫자를 뺴는 경우
        dfs(numbers, target, index + 1, sum - numbers[index]);

    }//dfs
}//solution