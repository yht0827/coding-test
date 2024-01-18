import java.util.*;

class Solution {
	static long answer = 0;
	static String op[] = {"+", "-", "*"};
	static boolean[] visited = new boolean[3];
	static ArrayList<Long> numList = new ArrayList<>();
	static ArrayList<String> opList = new ArrayList<>();
	static String[] perm = new String[3];

	public long solution(String expression) {
		String num = "";

		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '*' || c == '+' || c == '-') {
				opList.add(c + "");
				numList.add(Long.parseLong(num));
				num = "";
			} else {
				num += c;
			}
		}

		numList.add(Long.parseLong(num));

		makePermutation(0);

		return answer;
	}

	static void makePermutation(int depth) {
		if (depth == op.length) {
			sol();
			return;
		}

		for (int i = 0; i < op.length; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			perm[depth] = op[i];
			makePermutation(depth + 1);
			visited[i] = false;
		}
	}

	static void sol() {
		ArrayList<String> oper = new ArrayList<String>();
		oper.addAll(opList);

		ArrayList<Long> num = new ArrayList<Long>();
		num.addAll(numList);

		for (int i = 0; i < perm.length; i++) {
			String op = perm[i];
			for (int j = 0; j < oper.size(); j++) {
				if (oper.get(j).equals(op)) {
					long n1 = num.get(j);
					long n2 = num.get(j + 1);
					long res = cal(n1, n2, op);

					num.remove(j + 1);
					num.remove(j);
					oper.remove(j);

					num.add(j, res);

					j--;
				}
			}
		}

		answer = Math.max(answer, Math.abs(num.get(0)));
	}

	static long cal(long n1, long n2, String op) {
		long res = 0;
		switch (op) {
			case "*":
				res = n1 * n2;
				break;
			case "+":
				res = n1 + n2;
				break;
			case "-":
				res = n1 - n2;
				break;
		}

		return res;
	}
}