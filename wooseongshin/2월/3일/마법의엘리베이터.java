class Solution {
    public int solution(int storey) {
        int totalSteps = 0;

        while (storey != 0) {
            int onesPlace = storey % 10;
            int tensPlace = (storey / 10) % 10;

            if (onesPlace > 5) {
                totalSteps += (10 - onesPlace);
                storey += 10;
            } else if (onesPlace == 5) {
                totalSteps += onesPlace;
                storey += (tensPlace < 5 ? 0 : 10);
            } else {
                totalSteps += onesPlace;
            }

            storey /= 10;
        }

        return totalSteps;
    }
}
