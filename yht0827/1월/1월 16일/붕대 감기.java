import java.util.*;

class Solution {
	public int solution(int[] bandage, int health, int[][] attacks) {
		Map<Integer, Integer> atk = new HashMap<>();
		for (int[] attack : attacks)
			atk.put(attack[0], attack[1]);

		int successive = 0;
		int hpmax = health;

		for (int t = 0; t <= attacks[attacks.length - 1][0]; t++) {

			if (atk.containsKey(t)) {
				health -= atk.get(t);
				successive = 0;
			} else {
				health = Math.min(hpmax, health + bandage[1]);
				successive++;

				if (successive == bandage[0]) {
					health = Math.min(hpmax, health + bandage[2]);
					successive = 0;
				}
			}

			if (health <= 0)
				return -1;
		}

		return health;
	}
}