class Solution {
	public String solution(String p) {
		return replaceString(p);
	}

	public static String replaceString(String p) {

		if (p.equals(""))
			return p;

		int check = 0;
		String u = "";
		String v = "";

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(')
				check++;
			else if (p.charAt(i) == ')')
				check--;

			if (check == 0) {
				u = p.substring(0, i + 1);
				v = p.substring(i + 1);
				break;
			}
		}

		if (check(u))
			return u + replaceString(v);

		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(replaceString(v));
		sb.append(")");

		for (int i = 1; i < u.length() - 1; i++) {
			if (u.charAt(i) == '(')
				sb.append(")");
			else
				sb.append("(");
		}

		return sb.toString();
	}

	public static boolean check(String u) {
		boolean check = true;
		int temp = 0;

		for (int i = 0; i < u.length(); i++) {
			if (u.charAt(i) == '(')
				temp++;
			if (u.charAt(i) == ')')
				temp--;

			if (temp < 0) {
				check = false;
				break;
			}
		}
		return check;
	}
}