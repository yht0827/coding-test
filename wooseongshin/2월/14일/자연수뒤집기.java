class Solution {
    public int[] solution(long n) {
        int i=0;
        int[] arr = new int[(int)Math.log10(n)+1];
        while(n>0){
            arr[i]=(int)(n%10);
            n/=10;
            i++;
        }
        return arr;
    }
}
