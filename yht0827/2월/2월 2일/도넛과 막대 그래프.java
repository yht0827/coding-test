import java.util.*;

class Solution {
	public int[] solution(int[][] edges) {
		int[] answer = new int[4];

		int[] edgein = new int[1000001];
		ArrayList<Integer>[] adjL = new ArrayList[1000001];

		for (int i = 0; i < edges.length; i++) {
			edgein[edges[i][1]]++;
			if (adjL[edges[i][0]] == null) {
				adjL[edges[i][0]] = new ArrayList<Integer>();
			}
			adjL[edges[i][0]].add(edges[i][1]);
		}

		for (int i = 0; i < edgein.length; i++) {
			if (adjL[i] != null && adjL[i].size() >= 2 && edgein[i] == 0) {
				answer[0] = i;
				break;
			}
		}

		for (int i = 0; i < adjL[answer[0]].size(); i++) {
			int S = adjL[answer[0]].get(i);

			if (adjL[S] == null) {
				answer[2]++;
				continue;
			}

			int cur = adjL[S].get(0);

			while (true) {
				if (adjL[cur] == null) {
					answer[2]++;
					break;
				} else if (adjL[cur].size() == 2) {
					answer[3]++;
					break;
				} else if (cur == S) {
					answer[1]++;
					break;
				}
				cur = adjL[cur].get(0);
			}

		}

		return answer;
	}
}