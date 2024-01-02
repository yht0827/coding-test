class Solution4 {
    public int[] solution(String[]park, String[]routes) {

        int x = 0;
        int y = 0;

        char[][] parkArea = new char[park.length][park[0].length()];

        for (int i=0; i<park.length; i++) {
            parkArea[i] =park[i].toCharArray();

            if (park[i].contains("S")) {
                x =park[i].indexOf("S");
                y = i;
            }
        }

        for (String route :routes) {
            String direction = route.split(" ")[0];
            int distance = Integer.parseInt(route.split(" ")[1]);

            int nx = x;
            int ny = y;

            for (int i=0; i<distance; i++) {
                if(direction.equals("E")) nx++;
                if(direction.equals("W")) nx--;
                if(direction.equals("S")) ny++;
                if(direction.equals("N")) ny--;

                if (nx>=0 && ny >=0 && ny<parkArea.length && nx < parkArea[0].length) {
                    if(parkArea[ny][nx] == 'X') {
                        break;
                    }
                    if(i == distance-1) {
                        x = nx;
                        y = ny;
                    }
                }
            }
        }
        return new int[]{y, x};
    }
}