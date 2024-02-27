import java.util.*;

class Solution {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int answer2= 0;
        //1을 원소로 가지고 있다면, 실패.
        for(int x: arrayA){
            if(x==1) return answer;

        }
        for(int x: arrayB){
            if(x==1) return answer;
        }

        //약수를 배열에 담는다.
        int[] arr = yaksoo(arrayA);
        //이 list의 각 요소를 다른배열에 나누었을 때, 나머지가 0이되면 안됨.
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0){//arr에 저장된 공통 약수에 대해
                boolean isTrue= true;
                int num = 0;
                for(int y:arrayB){ //B에 나누어지는지 판별
                    if(y%i!=0){
                        num = i;
                    }//if
                }//for
                if(isTrue){
                    answer = Math.max(answer, i);
                }

            }//if
        }//for

        //약수를 배열에 담는다.
        int[] arr2 = yaksoo(arrayB);
        //이 list의 각 요소를 다른배열에 나누었을 때, 나머지가 0이되면 안됨.
        for(int i=0; i<arr2.length; i++){
            if(arr2[i]!=0){//arr에 저장된 공통 약수에 대해
                boolean isTrue= true;
                int num = 0;
                for(int y:arrayA){ //B에 나누어지는지 판별
                    if(y%i==0) isTrue=false;
                    else if(y%i!=0){
                        num = i;

                    }//if
                }//for
                if(isTrue){
                    answer2 = Math.max(answer2, i);
                }

            }//if
        }//for

        answer = Math.max(answer,answer2);



        return answer;
    }


    private static int[] yaksoo(int[] arrAB){
        //가장 큰 요소의 길이만큼 약수 후보배열 만들기
        int max = 0;
        for(int x: arrAB){
            max = Math.max(max,x);
        }
        int[] resultArr = new int[max+1];

        //배열을 순회하며 각 약수를 새로운배열에 저장하고 list에 추가.
        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0; i<arrAB.length; i++){
            int[] yaksooArr = new int[max+1];
            int number = arrAB[i];
            int j=2;
            while(j<max+1){
                if(number%j==0) {//만약 j의 약수라면
                    yaksooArr[j]++;//j 추가하고
                }
                j++;

            }//while

            list.add(yaksooArr);
        }


        //list 요소의 갯수가 1개라면 그냥 리턴해준다.
        if(list.size()==1){
            return list.get(0);
        }
        //그게아니라면 list에서 가장 작은 값들끼리 비교해서 resultArr를 완성시킨다.
        int[] temp = list.get(0);
        for(int i=0; i<list.size()-1; i++){
            for(int j=0; j<max; j++){
                resultArr[j] = Math.min(list.get(i)[j],list.get(i+1)[j]);
            }//for2
        }//for1




        return resultArr;
    }
}