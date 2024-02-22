class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for (int i = 0; i < babbling.length; i++) {
            int[] arr = { 1, 1, 1, 1 };

            while (babbling[i].indexOf("aya") != -1
                    || babbling[i].indexOf("ye") != -1
                    || babbling[i].indexOf("woo") != -1
                    || babbling[i].indexOf("ma") != -1) {
                if (babbling[i].indexOf("aya") != -1) {
                    arr[0]--;
                    String temp = babbling[i];
                    babbling[i] = temp.replaceFirst("aya", "xxx");
                } else if (babbling[i].indexOf("ye") != -1) {
                    arr[1]--;
                    String temp = babbling[i];
                    babbling[i] = temp.substring(0, babbling[i].indexOf("ye")) + "xx"
                            + temp.substring(babbling[i].indexOf("ye") + 2, babbling[i].length());
                } else if (babbling[i].indexOf("woo") != -1) {
                    arr[2]--;
                    String temp = babbling[i];
                    babbling[i] = temp.substring(0, babbling[i].indexOf("woo")) + "xxx"
                            + temp.substring(babbling[i].indexOf("woo") + 3, babbling[i].length());
                } else if (babbling[i].indexOf("ma") != -1) {
                    arr[3]--;
                    String temp = babbling[i];
                    babbling[i] = temp.substring(0, babbling[i].indexOf("ma")) + "xx"
                            + temp.substring(babbling[i].indexOf("ma") + 2, babbling[i].length());
                }
            }

            boolean isTrue = true;
            for (int x : arr) {
                if (x < 0) {
                    isTrue = false;
                }
            }
            for (int j = 0; j < babbling[i].length(); j++) {
                if (babbling[i].charAt(j) != 'x') {
                    isTrue = false;
                }
            }

            if (isTrue)
                answer++;

        } // for

        return answer;
    }
}