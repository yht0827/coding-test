/*
아래 링크의 코드를 참고하였습니다.
https://hyojun.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%82%BC%EA%B0%81-%EB%8B%AC%ED%8C%BD%EC%9D%B4-Java
*/

class Solution29 {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] tri = new int[n][n];

        int x = -1;
        int y = 0;
        int num = 1;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i % 3 == 0) {
                    x++;
                }
                else if(i % 3 == 1) {
                    y++;
                }
                else if(i % 3 == 2) {
                    x--;
                    y--;
                }
                tri[x][y] = num++;
            }
        }

        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(tri[i][j] == 0) break;
                answer[index++] = tri[i][j];
            }
        }

        return answer;
    }
}