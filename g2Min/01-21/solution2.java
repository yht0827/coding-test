//멀쩡한 사각형
public class Solution {
    public long solution(int w, int h) {
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
    }

    @Test
    public void 정답() {
        Assert.assertEquals(80, solution(8, 12));
        Assert.assertEquals(80, solution(12, 8));
        Assert.assertEquals(12, solution(4, 4));
    }
}