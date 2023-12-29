//공원산첵

import java.util.*;

class solution2 {
    public int[] solution(String[] park, String[] routes) {

        // 이차원 배열을 새로 만들면서, 로봇의 시작 위치를 찾는다.
        int robotRow = -1;
        int robotColumn = -1;

        int rowNum = park.length;
        int columnNum = park[0].length();

        char [][] parkArray = new char[rowNum][columnNum];

        for (int i=0 ; i< rowNum; i++) { //50
            String rowData = park[i];
            for (int j=0 ; j<columnNum ;j++) { //50

                char locationData = rowData.charAt(j);
                parkArray[i][j] = locationData;

                if (locationData == 'S') {
                    robotRow = i;
                    robotColumn = j;
                }
            }
        }


        // 좌표 값 저장
        Map<Character, List<Integer>> dirMove = new HashMap<Character, List<Integer>>();
        dirMove.put('E', List.of(0,1));
        dirMove.put('W', List.of(0,-1));
        dirMove.put('N', List.of(-1,0));
        dirMove.put('S', List.of(1,0));


        // routes 만큼 반복한다.
        for (String route : routes) {

            char direction = route.charAt(0);
            Integer move = route.charAt(2) - '0';


            // 이동할 위치 계산
            // 현재 위치를 먼저 저장한다. (현재 명령이 불가능하다면 롤백을 해주기 위함)
            int tmpRow = robotRow;
            int tmpColumn = robotColumn;

            Boolean possible = true;

            // 해당 방향으로 몇칸을 이동해야해서, 한칸씩 이동하며 가능성을 확인한다.
            for (int i=0; i<move; i++) {

                Integer moveRow = robotRow + dirMove.get(direction).get(0);
                Integer moveColumn = robotColumn + dirMove.get(direction).get(1);

                // 공원 바깥이면 실패
                if ( 0 > moveRow || moveRow >= rowNum || 0 > moveColumn || moveColumn >= columnNum) {
                    possible = false;
                    break;
                }

                // 장애물을 만나면 실패
                if (parkArray[moveRow][moveColumn] == 'X') {
                    possible = false;
                    break;
                }

                //실제 이동
                parkArray[moveRow][moveColumn] = 'S';
                parkArray[robotRow][robotColumn] = 'O';

                robotRow = moveRow;
                robotColumn = moveColumn;
            }

            //불가능한 경우가 존재하면 롤백
            if (possible == false) {
                robotRow = tmpRow ;
                robotColumn = tmpColumn;
            }
        }

        // 마지막에 로봇의 위치를 배열에 저장해서 return하면 끝
        int[] answer = new int[2];
        answer[0] = robotRow;
        answer[1] = robotColumn;
        return answer;
    }
}