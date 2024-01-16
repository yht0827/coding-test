class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int time = 1;
        int healthTime = 0;
        int attacksIndex = 0;
        
        while(time <= attacks[attacks.length-1][0]){
            if(attacks[attacksIndex][0] == time){
                healthTime = 0;
                health -= attacks[attacksIndex++][1];
                if(health <= 0)
                    return -1;
            } else {
                healthTime++;
                if(healthTime % bandage[0] == 0){
                    health = Math.min(health+bandage[2]+bandage[1], maxHealth);
                } else {
                    health = Math.min(health+bandage[1], maxHealth);
                }
            }
            time++;
        }
        
        return health;
    }
}
