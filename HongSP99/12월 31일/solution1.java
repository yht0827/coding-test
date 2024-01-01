import java.util.*;
class Pair{
    int s;
    int e;
    Pair(int s, int e){
        this.s = s;
        this.e = e;
    }
}
class Solution {
    static ArrayList<Pair> arr;
    static ArrayList<Integer> list;
    public int solution(String[][] book) {
        int answer = 0;
        list = new ArrayList<Integer>();
        arr = new ArrayList<Pair>();
        for(int i=0;i<book.length;i++){
            String[] tmp_s = book[i][0].split(":");
            String[] tmp_e = book[i][1].split(":");
            int sum_s = Integer.parseInt(tmp_s[0])*60 + Integer.parseInt(tmp_s[1]);
            int sum_e = Integer.parseInt(tmp_e[0])*60 + Integer.parseInt(tmp_e[1])+10;
            arr.add(new Pair(sum_s,sum_e));
        }
        Collections.sort(arr,(i,j)->{
            return Integer.compare(i.e,j.e);
        });
        list.add(arr.get(0).e);
        for(int i =1;i<arr.size();i++){
            boolean f = true;
            for(int j=0;j<list.size();j++){
                if(list.get(j) <= arr.get(i).s){
                    f = false;
                    list.set(j,arr.get(i).e);
                    break;
                }
            }
            
            if(f){
                list.add(arr.get(i).e);
            }
            Collections.sort(list,(ii,jj)->{
                return Integer.compare(jj,ii);
            });
        }

        return list.size();
    }
}
