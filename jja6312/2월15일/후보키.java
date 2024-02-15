import java.util.*;

class Solution {
    private int answer = 0;
    private String[][] relation;
    private List<Set<Integer>> candidateKeys;

    public int solution(String[][] relation) {
        this.relation = relation;
        candidateKeys = new ArrayList<>();
        boolean[] visited = new boolean[relation[0].length];

        for (int i = 1; i <= relation[0].length; i++) {
            dfs(0, 0, i, visited);
        }

        return answer;
    }

    private void dfs(int start, int depth, int limit, boolean[] visited) {
        if (depth == limit) {
            Set<Integer> currentSet = new HashSet<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) currentSet.add(i);
            }

            if (isUnique(currentSet) && isMinimal(currentSet)) {
                candidateKeys.add(new HashSet<>(currentSet));
                answer++;
            }
            return;
        }

        for (int i = start; i < relation[0].length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1, limit, visited);
                visited[i] = false;
            }
        }
    }

    private boolean isUnique(Set<Integer> currentSet) {
        Set<String> values = new HashSet<>();

        for (String[] tuple : relation) {
            StringBuilder sb = new StringBuilder();
            for (int index : currentSet) {
                sb.append(tuple[index]).append(",");
            }
            values.add(sb.toString());
        }

        return values.size() == relation.length;
    }

    private boolean isMinimal(Set<Integer> currentSet) {
        for (Set<Integer> key : candidateKeys) {
            if (currentSet.containsAll(key)) {
                return false;
            }
        }
        return true;
    }
}
