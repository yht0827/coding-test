import java.util.Stack;

class Solution20 {
    public String solution(String p) {
        if (check(p))
            return p;
        else {
            return dfs(p);
        }
    }

    private static boolean check(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                st.add(c);
            } else {
                if (st.isEmpty()) return false;
                else st.pop();
            }
        }
        if (!st.isEmpty()) return false;
        else return true;
    }
    private static String dfs(String s) {
        if (s.length() == 0) return s;

        String u ="", v = "";
        int cnt1 = 0, cnt2 = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                cnt1++;
            } else {
                cnt2++;
            }

            if (((cnt1 > 0) && (cnt2 > 0)) && (cnt1 == cnt2)) {
                u = s.substring(0, i + 1);
                if (i < s.length() - 1) {
                    v = s.substring(i + 1, s.length());
                    break;
                }
            }
        }
        if (check(u)) {
            return u + dfs(v);
        } else {
            String tmp = "(" + dfs(v) + ")";
            u = u.substring(1, u.length() - 1);
            u = u.replace("(", ".");
            u = u.replace(")", "(");
            u = u.replace(".", ")");
            tmp = tmp + u;
            return tmp;
        }
    }
}