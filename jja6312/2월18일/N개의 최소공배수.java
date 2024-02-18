import java.util.*;

class Solution {
    public int solution(int[] arr) {
        // 2 2,3 2,2,2 2,7
        // 2,2,2 3 7
        Solution solution = new Solution();

        // 1. 각 요소를 소수의 곱으로 분할한다.
        // 어레이리스트로 저장하고, 배열에 넣는다.
        ArrayList[] store = new ArrayList[arr.length]; // 각 요소의 약수를 ArrayList로가지고있는 집합.
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            store[i] = solution.devideSosu(arr[i]);
            maxLen = Math.max(maxLen, arr[i]);// 가장 큰 요소
        }

        int[] maxArr = new int[maxLen + 1]; // 가장 큰 요소 길이 +1만큼의 maxArr
        for (ArrayList<Integer> x : store) {
            int[] allArr = new int[maxLen + 1];
            for (int i = 0; i < x.size(); i++) {
                allArr[x.get(i)]++;
            }

            for (int i = 2; i < maxLen + 1; i++) {
                maxArr[i] = Math.max(allArr[i], maxArr[i]);
            }
        }
        int answer = 0;

        // 2. 요소의 최대갯수끼리 곱해서 결과값을 구한다.
        int mul = 1;
        for (int i = 2; i <= maxLen; i++) {
            if (maxArr[i] != 0) {

                for (int j = 0; j < maxArr[i]; j++) {
                    mul *= i;
                }

            }
        }
        answer += mul;
        return answer;
    }

    private ArrayList<Integer> devideSosu(int n) {
        // System.out.println("n:"+n);
        ArrayList<Integer> list = new ArrayList<>();
        int nowVal = n;
        while (nowVal != 1) {
            for (int i = 2; i <= n; i++) {
                if (nowVal % i == 0) {
                    list.add(i);
                    nowVal /= i;
                    break;
                }
            }
        }

        return list;
    }
}