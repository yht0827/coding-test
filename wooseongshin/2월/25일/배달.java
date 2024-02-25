import java.util.*;
class Solution {
    private static final int MAX_DISTANCE = 500001;

    public int solution(int N, int[][] road, int K) {
        int reachableCities = 0;
        int[][] cityDistances = initializeCityDistances(N);

        updateRoadDistances(road, cityDistances);
        applyFloydWarshallAlgorithm(N, cityDistances);

        for (int i = 0; i < N; i++) {
            if(cityDistances[0][i] <= K) {
                reachableCities++;
            }
        }

        return reachableCities;
    }

    private int[][] initializeCityDistances(int N) {
        int[][] cityDistances = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(cityDistances[i], MAX_DISTANCE);
            cityDistances[i][i] = 0;
        }

        return cityDistances;
    }

    private void updateRoadDistances(int[][] road, int[][] cityDistances) {
        for (int[] path : road) {
            int cityA = path[0] - 1;
            int cityB = path[1] - 1;
            int distance = path[2];

            cityDistances[cityA][cityB] = Math.min(cityDistances[cityA][cityB], distance);
            cityDistances[cityB][cityA] = Math.min(cityDistances[cityB][cityA], distance);
        }
    }

    private void applyFloydWarshallAlgorithm(int N, int[][] cityDistances) {
        for (int intermediate = 0; intermediate < N; intermediate++) {
            for (int start = 0; start < N; start++) {
                for (int end = 0; end < N; end++) {
                    if(cityDistances[start][end] > cityDistances[start][intermediate] + cityDistances[intermediate][end]) {
                        cityDistances[start][end] = cityDistances[start][intermediate] + cityDistances[intermediate][end];
                    }
                }
            }
        }
    }
}
