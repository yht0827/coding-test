import java.util.*;

class Solution {
	public String[] solution(String[] players, String[] callings) {
		int numOfPlayers = players.length;
		Map<String, Integer> ranking = new HashMap<>();

		for (int i = 0; i < numOfPlayers; i++) {
			ranking.put(players[i], i);
		}

		for (String player : callings) {
			int playerRanking = ranking.get(player);

			String frontPlayer = players[playerRanking - 1];

			ranking.replace(frontPlayer, playerRanking);
			players[playerRanking] = frontPlayer;

			ranking.replace(player, playerRanking - 1);
			players[playerRanking - 1] = player;
		}

		return players;
	}
}