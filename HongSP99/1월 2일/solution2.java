import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Stack<Integer> Rst = new Stack<>();
        Stack<Integer> Lst = new Stack<>();
        int[][] keypad = {{1,2,3}, {4,5,6}, {7,8,9}, {10,0,11}};

        Lst.push(10);
        Rst.push(11);

        int posX = 0, posY = 0, posLX = 0, posLY = 0, posRX= 0, posRY = 0;

        for(int i = 0; i<numbers.length; i++) {
            for(int x= 0; x < 4; x++) {
                for(int y = 0; y <3; y++) {
                    if(numbers[i] == keypad[x][y]) {
                        posX = x;
                        posY = y;
                    }
                    if(Lst.peek() == keypad[x][y]) {
                        posLX = x;
                        posLY = y;
                    }
                    if(Rst.peek() == keypad[x][y]) {
                        posRX = x;
                        posRY = y;
                    }
                }
            }
            if(posY ==0) {
                answer += "L";
                Lst.push(numbers[i]);
            }
            else if (posY == 2) {
                answer += "R";
                Rst.push(numbers[i]);
            }
            else {
                int disL = Math.abs(posX - posLX) + Math.abs(posY - posLY);
                int disR = Math.abs(posX - posRX) + Math.abs(posY - posRY);

                if(disL < disR) {
                    answer += "L";
                    Lst.push(numbers[i]);
                }
                else if (disL > disR) {
                    answer += "R";
                    Rst.push(numbers[i]);
                }
                else {
                    if(hand.equals("left")) {
                        answer += "L";
                        Lst.push(numbers[i]);
                    }
                    else {
                        answer += "R";
                        Rst.push(numbers[i]);
                    }
                }
            }

        }

        return answer;
    }
}
