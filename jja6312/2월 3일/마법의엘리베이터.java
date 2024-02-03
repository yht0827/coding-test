class Solution {
    public int solution(int storey) {
        int answer = 0;
        //몇자리 수인지 봐야한다.
        //만약 10이라면, 100으로나누었을 때 0이나옴. 즉 자릿수를 1부터 해서 , 0이나올때까지 10씩곱해가면서 나눠보자.
        int whatIsLength = 1;
        int count = 0;
        while(storey/whatIsLength!=0){
            count++; // 나눠지면? n자리수.
            whatIsLength *= 10; //10씩 곱해간다.
        }
        //count 자리수니까.

        //1의자릿수가 5라면, answer에 5를 더한다.

        //else if 5보다 작다면, answer에 그 만큼 더한다.
        //else if 5보다 크다면, answer에 10에서 그 만큼 뺸 값을 더하고 십의 자릿수를 늘린다.(+10)

        //십으로 나눈다.
        //이러한 행위를 count만큼 반복한다.
        int value = storey; //밸류는 처음 숫자다.
        int countValue = count; //카운트 밸류는 현재 밸류가 몇자리수인지 나타내고있다.
        for(int i=0; i<count; i++){ //자릿수만큼 행위를 반복한다.
            String valueString = ""+value;
            int oneOfValue = Integer.parseInt(String.valueOf(valueString.charAt(countValue-1))); //밸류의 1의자리를 추출한다.
            if(oneOfValue==5){ //1의자리가 5라면
                answer+=5; //5를 값에 더한다.
            }else if(oneOfValue<5){ //5보다작으면
                answer+=oneOfValue; //1의자리만큼더한다.
            }else if(oneOfValue>5){ //5보다 크면
                answer+=10-oneOfValue; //10에서 1의자리를 뺀만큼 더한다.
                value+=10; //찐밸류엔 10을더해주고
            }
            value /= 10; //밸류를 10으로 나눈다.
            countValue--; //현재 밸류의 길이가 1만큼짧아진것을 업데이트.
        }

        return answer;
    }
}