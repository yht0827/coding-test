import java.util.*;

class Solution53 {
    public int[] solution(String[] wallpaper) {

        int row = wallpaper.length;
        int column = wallpaper[0].length();

        int fileMaxLeft = column;
        int fileMaxRight = 0;
        int fileMaxTop = row;
        int fileMaxBottom = 0;

        for (int i = 0 ; i < row ; i++ ) {
            for (int j = 0 ; j < column ; j++ ) {

                char space = wallpaper[i].charAt(j);

                if (space == '#') {
                    if (j < fileMaxLeft)
                        fileMaxLeft = j;
                    if (fileMaxRight < j)
                        fileMaxRight = j;

                    if(i < fileMaxTop)
                        fileMaxTop = i;
                    if(fileMaxBottom < i)
                        fileMaxBottom = i;
                }
            }
        }

        int[] answer = {fileMaxTop, fileMaxLeft, fileMaxBottom+1, fileMaxRight+1};

        return answer;
    }
}