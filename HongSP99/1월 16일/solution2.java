class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int nextIndex = 0;
        int noPaintSection = section[nextIndex];
        int sectionRange = 0;
        boolean isLast = false;
        
        for(int i = 0 ; i < section.length ; i++){
            while(nextIndex < section.length-1){
                sectionRange = section[++nextIndex] - noPaintSection + 1;
                if(sectionRange >= m){
                    answer++;
                    break;
                }
            }
            if(sectionRange == m && nextIndex < section.length-1){
                noPaintSection = section[++nextIndex];
                System.out.println(nextIndex);
                isLast = false;
                i = nextIndex;
            } else {
                noPaintSection = section[nextIndex];
                isLast = true;
                i = nextIndex;
            }
        }
        
        if(sectionRange != m || !isLast){
            answer++;
        }
        
        return answer;
    }
}
