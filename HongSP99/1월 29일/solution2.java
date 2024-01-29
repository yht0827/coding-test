    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        // 1
        String[] advanceSkill = skill.split("");
        // 2
        for(int i=0; i<skill_trees.length; i++) {
            boolean flag = true;
            // 3
            for(int j=1; j<advanceSkill.length; j++) {
            	// 4
                int start = skill_trees[i].indexOf(advanceSkill[j-1]);
                int end = skill_trees[i].indexOf(advanceSkill[j]);
                // 5
                if(start == -1 && end != -1) {
                    flag = false;
                }
                // 6
                if(end != -1 && start > end) {
                    flag = false;
                }
                // 7
                if(flag == false) break;
            }
            // 8
            if(flag) answer++;
        }
        return answer;
    }
