import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*https://velog.io/@pppp0722/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Level2-%EB%A9%94%EB%89%B4-%EB%A6%AC%EB%89%B4%EC%96%BC-Java
위 사이트의 코드 참고하였습니다*/

class Solution44 {

    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();
        for (String order : orders) {
            order = sortString(order);
            dfs(new boolean[order.length()], order, 0, course, map);
        }
        List<String> keySetList = new ArrayList<>(map.keySet());
        for (int i = 0; i < keySetList.size(); i++) {
            String key = keySetList.get(i);
            if (map.get(key) < 2) {
                keySetList.remove(i--);
                continue;
            }
            for (int courseLength : course) {
                if (key.length() != courseLength) {
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    String preKey = keySetList.get(j);
                    if (key.length() != preKey.length()) {
                        continue;
                    }
                    if (map.get(key) < map.get(preKey)) {
                        keySetList.remove(i--);
                        break;
                    } else if (map.get(key) > map.get(preKey)) {
                        keySetList.remove(j--);
                        i--;
                    }
                }
            }
        }
        Collections.sort(keySetList);
        return keySetList.toArray(new String[0]);
    }

    public void dfs(boolean[] visited, String order, int depth, int[] course,
                    Map<String, Integer> map) {
        if (depth == order.length()) {
            String menu = "";
            for (int i = 0; i < order.length(); i++) {
                if (visited[i]) {
                    menu += order.charAt(i);
                }
            }
            if (menu.length() < 2) {
                return;
            }
            for (int courseLength : course) {
                if (menu.length() == courseLength) {
                    if (!map.containsKey(menu)) {
                        map.put(menu, 1);
                    } else {
                        map.replace(menu, map.get(menu) + 1);
                    }
                }
            }
        } else {
            visited[depth] = true;
            dfs(visited, order, depth + 1, course, map);
            visited[depth] = false;
            dfs(visited, order, depth + 1, course, map);
        }
    }

    public String sortString(String string) {
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}