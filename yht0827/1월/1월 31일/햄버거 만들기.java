public int solution(int[] ingredient) {
	int[] newIngredient = new int[ingredient.length];
	int idx = 0, answer = 0;
	for (int ing : ingredient) {
		newIngredient[idx] = ing;
		idx++;

		if (idx >= 4) {
			if (newIngredient[idx - 4] == 1 && newIngredient[idx - 3] == 2 && newIngredient[idx - 2] == 3
				&& newIngredient[idx - 1] == 1) {
				idx -= 4;
				answer++;
			}
		}
	}

	return answer;
}