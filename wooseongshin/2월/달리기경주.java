import java.util.HashMap;
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for(String calling: callings) {
            Integer i = map.get(calling);

            String frontPlayer = players[i-1];
            players[i-1] = calling;
            map.put(calling, i-1);

            players[i] = frontPlayer;
            map.put(frontPlayer, i);

        }


        return players;
    }
}
