import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        List<Integer> listA = getDivisors(arrayA);
        List<Integer> listB = getDivisors(arrayB);

        answer = findMaxCommonDivisor(listA, arrayB, answer);
        answer = findMaxCommonDivisor(listB, arrayA, answer);

        return answer;
    }

    private int findMaxCommonDivisor(List<Integer> list, int[] array, int answer) {
        for(int i=list.size()-1;i>=0;i--) {
            int num = list.get(i);

            if(isCommonDivisor(num, array) && answer<num) {
                answer = num;
                break;
            }
        }
        return answer;
    }

    private boolean isCommonDivisor(int num, int[] array) {
        for(int element : array) {
            if(element%num==0) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getDivisors(int[] array) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(array);
        int min = array[0];

        for(int i=2;i<=min;i++) {
            if(isCommonDivisor(i, array)) {
                list.add(i);
            }
        }

        return list;
    }
}
