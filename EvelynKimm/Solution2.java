class Solution2 {
    static final int[] discountRatio = {90, 80, 70, 60};
    static int EMOTICON_PLUS = 0;
    static int TOTAL_REVENUE = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        searchPrice(users, emoticons, 0, new int[emoticons.length]);
        return new int[] {EMOTICON_PLUS, TOTAL_REVENUE};
    }

    private void searchPrice(int[][] users, int[] emoticons, int cur, int[] rates) {
        if (cur == emoticons.length) {
            updateAnswer(users, emoticons, rates);
            return;
        }
        for (int rate : discountRatio) {
            rates[cur] = rate;
            searchPrice(users, emoticons, cur+1, rates);
        }
    }

    private void updateAnswer(int[][] users, int[] emoticons, int[] rates) {
        int newEmoticonPlus = 0;
        int emoticonRevenue = 0;

        for (int[] user : users) {
            int revenue = 0;
            int userRate = user[0];
            int userPrice = user[1];

            for (int i=0; i<rates.length; i++) {
                if (100 - rates[i] >= userRate) {
                    revenue += emoticons[i] * rates[i] / 100;
                }
                if (revenue >= userPrice) {
                    newEmoticonPlus += 1;
                    revenue = 0;
                    break;
                }
            }
            emoticonRevenue += revenue;
        }

        if(newEmoticonPlus > EMOTICON_PLUS) {
            EMOTICON_PLUS = newEmoticonPlus;
            TOTAL_REVENUE = emoticonRevenue;
        } else if (newEmoticonPlus == EMOTICON_PLUS) {
            TOTAL_REVENUE = Math.max(emoticonRevenue, TOTAL_REVENUE);
        }
    }


}