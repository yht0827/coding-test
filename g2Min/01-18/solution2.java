// 수식최대화

import java.util.*;
class Solution {
    static char[] top = {'-', '*', '+'};
    long answer;
    public void swap(int a, int b){
        char k = top[a];
        top[a] = top[b];
        top[b] = k;
    }
    public long Calculate(ArrayList<Long> list, ArrayList<Character> c_list) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < c_list.size(); j++) {
                if(c_list.get(j) == top[i]) {
                    switch(top[i]) {
                        case '-':
                            list.add(j, list.remove(j) - list.remove(j));
                            break;
                        case '*':
                            list.add(j, list.remove(j) * list.remove(j));
                            break;
                        case '+':
                            list.add(j, list.remove(j) + list.remove(j));
                            break;
                    }
                    c_list.remove(j--);
                }
            }
        }
        return Math.abs(list.get(0));
    }
    public void perm(ArrayList<Long> list, ArrayList<Character> c_list, int depth) {
        if(depth == 3) {
            long temp = Calculate((ArrayList<Long>)list.clone(), (ArrayList<Character>)c_list.clone());
            if(temp > answer)
                answer = temp;
            return ;
        }
        for(int i = depth; i < 3; i++){
            swap(i, depth);
            perm(list,c_list,depth + 1);
            swap(i, depth);
        }
    }
    public long solution(String expression) {
        ArrayList<Long> list = new ArrayList();
        ArrayList<Character> c_list = new ArrayList();
        int i;
        String num = "";
        for(i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9')
            {
                num += expression.charAt(i);
            }
            else
            {
                list.add(Long.parseLong(num));
                num = "";
                c_list.add(expression.charAt(i));
            }
        }
        list.add(Long.parseLong(num));
        perm(list, c_list,0);
        return answer;
    }
}