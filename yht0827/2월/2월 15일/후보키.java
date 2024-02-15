import java.util.*;

class Solution {
	public int solution(String[][] relation) {
		List<Integer> candidateKey = new ArrayList<>();

		int rowLen = relation.length;
		int colLen = relation[0].length;

		for (int set = 1; set < (1 << colLen); set++) {

			if (!isMinimal(set, candidateKey))
				continue;

			if (isUnique(set, rowLen, colLen, candidateKey, relation)) {
				System.out.println(Integer.toBinaryString(set));
				candidateKey.add(set);
			}
		}

		return candidateKey.size();
	}

	private boolean isUnique(int set, int rowLen, int colLen, ArrayList<Integer> candidateKey, String[][] relation) {
		HashMap<String, String> map = new HashMap<>();

		for (int row = 0; row < rowLen; ++row) {
			String dataByKeySet = "";

			for (int th = 0; th < colLen; ++th) {
				if ((set & (1 << th)) != 0) {
					dataByKeySet += relation[row][th];
				}
			}

			if (map.containsKey(dataByKeySet))
				return false;
			else
				map.put(dataByKeySet, dataByKeySet);
		}

		return true;
	}

	private boolean isMinimal(int set, ArrayList<Integer> candidateKey) {
		for (int key : candidateKey) {
			if ((key & set) == key)
				return false;
		}

		return true;
	}
}