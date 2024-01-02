class Solution4 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;

        for (int number : numbers) {
            if (number==1 || number==4 || number==7) {
                answer += "L";
                left = number;
            } else if (number==3 || number==6 || number==9) {
                answer += "R";
                right = number;
            } else {
                // 더 가까운 손으로 누름
                if (number == 0) number = 11;
                int leftDist = Math.abs(number - left) / 3 + Math.abs(number - left) % 3;
                int rightDist = Math.abs(number - right) / 3 + Math.abs(number - right) % 3;

                if (leftDist < rightDist) {
                    answer += "L";
                    left = number;
                }
                else if (leftDist > rightDist) {
                    answer += "R";
                    right = number;
                }
                else {
                    if (hand.equals("left")) {
                        answer += "L";
                        left = number;
                    } else {
                        answer += "R";
                        right = number;
                    }
                }
            }
        }
        return answer;
    }
}