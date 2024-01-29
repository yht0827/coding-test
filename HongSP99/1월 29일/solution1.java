public String solution(int[] food) {
        String answer = "";

        // 인덱스 1부터 시작 index[0]은 물이다.
        for(int i=1; i<food.length; i++){
            if(food[i] == 1){ // index값이 1이면 넘긴다.
                continue;
            }
            else if(food[i] % 2 == 0){
                for(int j=0; j<food[i]/2; j++){
                    // index값이 짝수일때 food[i]/2만큼 toString을 사용하여 값 넣어준다.
                    answer+=Integer.toString(i);
                }
            }else{
                for(int j=0; j<(food[i]-1)/2; j++){
                    // index값이 홀수일때 food[i]/2만큼 toString을 사용하여 값 넣어준다.
                    answer+=Integer.toString(i);
                }
            }
        }

        String reverse = "";
        // 반대되는 값을 for문으로 역순으로 넣어준다.
        for(int i=answer.length()-1; i>=0; i--){
            if(i==answer.length()-1) reverse += "0";
            reverse += answer.charAt(i);
        }

        return answer + reverse;
   }
