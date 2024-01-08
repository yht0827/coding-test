import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {

    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        Pattern pattern = Pattern.compile("(?<=0)([1-9]+)(?=0)|^([1-9]+)(?=0)|(?<=0)([1-9]+)$|^([1-9]+)$");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            answer += isPrime(Long.parseLong(matcher.group())) ? 1 : 0;
        }
        return answer;
    }

    public boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
