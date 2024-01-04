import java.util.HashSet;
import java.util.Set;

class Solution7 {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for (int size = 1; size <= elements.length; size++) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = i; j < i + size; j++) {
                    sum += elements[j % elements.length];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}