class Solution {
	public int[] solution(String[] park, String[] routes) {
		int startX = 0;
		int startY = 0;
		int xLength = park[0].length();
		int yLength = park.length;
		char[][] parking = new char[park.length][park[0].length()];
		for(int i=0; i<park.length; i++) {
			for(int j=0; j<park[i].length(); j++) {
				parking[i][j] = park[i].charAt(j);
				if(park[i].charAt(j) == 'S') {
					startX = j;
					startY = i;
				}
			}
		}

		String[] where = new String[routes.length];
		int[] length = new int[routes.length];
		for(int i=0; i<routes.length; i++) {
			where[i] = routes[i].split(" ")[0];
			length[i] = Integer.parseInt(routes[i].split(" ")[1]);
		}

		char now = 0;
		int nowX = startX;
		int nowY = startY;
		for(int i=0; i<routes.length; i++) {
			for(int j=1; j<=length[i]; j++) {
				switch(where[i]) {
					case "E":
						if(startX+length[i] >= xLength) break;
						now = parking[startY][startX + j];
						nowX = startX+j;
						break;
					case "W":
						if(startX-length[i] < 0) break;
						now = parking[startY][startX - j];
						nowX = startX-j;
						break;
					case "S":
						if(startY+length[i] >= yLength) break;
						now = parking[startY+j][startX];
						nowY = startY+j;
						break;
					case "N":
						if(startY-length[i] < 0) break;
						now = parking[startY-j][startX];
						nowY = startY-j;
						break;
				}
				if(now == 'X' || now == 0) {
					nowX = startX;
					nowY = startY;
					break;
				}
			}
			if(now != 'X' && now != 0) {
				startX = nowX;
				startY = nowY;
			}
		}
		return new int[]{startY, startX};
	}
}