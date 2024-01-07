mport java.util .*;

class Solution {
	public long solution(int cap, int n, int[] d, int[] p) {

		long answer = 0;
		int len = d.length;
		//val, idx
		LinkedList<int[]> l1 = new LinkedList<>();
		LinkedList<int[]> l2 = new LinkedList<>();
		for (int i = 0; i < len; i++) {
			if (d[i] > 0)
				l1.add(new int[] {d[i], i + 1});
			if (p[i] > 0)
				l2.add(new int[] {p[i], i + 1});
		}
		int sum = 0;
		int dist = 0;
		while (!l1.isEmpty() || !l2.isEmpty()) {
			sum = 0;
			dist = 0;
			while (!l1.isEmpty() && sum < cap) {
				int[] c = l1.pollLast();
				dist = Math.max(dist, c[1]);

				if (c[0] + sum <= cap) {
					sum += c[0];
				} else {
					c[0] -= (cap - sum);
					l1.add(c);
					break;
				}
			}
			sum = 0;
			while (!l2.isEmpty() && sum < cap) {
				int[] c = l2.pollLast();
				dist = Math.max(dist, c[1]);

				if (c[0] + sum <= cap) {
					sum += c[0];
				} else {
					c[0] -= (cap - sum);
					l2.add(c);
					break;
				}
			}
			answer += dist * 2;
		}

		return answer;
	}
}