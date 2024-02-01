class Solution {
	public int[] solution(String[] wallpaper) {
		int minRow, minCol;
		int maxRow, maxCol;

		minRow = minCol = Integer.MAX_VALUE;
		maxRow = maxCol = Integer.MIN_VALUE;

		int row = wallpaper.length;
		int col = wallpaper[0].length();

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (wallpaper[r].charAt(c) == '#') {
					minRow = Math.min(minRow, r);
					minCol = Math.min(minCol, c);
					maxRow = Math.max(maxRow, r);
					maxCol = Math.max(maxCol, c);
				}
			}
		}

		return new int[] {minRow, minCol, maxRow + 1, maxCol + 1};
	}
}