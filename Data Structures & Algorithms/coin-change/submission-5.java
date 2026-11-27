class Solution {
    int maxCoins = 0;
    int memo[];
    public int coinChange(int[] coins, int amount) {
        maxCoins = amount + 1;
        memo = new int[amount+1];
        memo[0] = 0;
        for(int i=1; i<maxCoins; i++){
            int min = maxCoins;
            for(int coin:coins){
                if(i-coin < 0){
                    continue;
                }
                min = Math.min(min, 1 + memo[i - coin]);
            }
            memo[i] = min;
        }

        return memo[amount] == maxCoins ? -1 : memo[amount];
    }

    private int countFewCoins(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }

        if(amount <= 0){
            return maxCoins;
        }

        if(memo[amount] != maxCoins+1){
            return memo[amount];
        }

        int min = maxCoins;
        for(int coin:coins){
            min = Math.min(min, countFewCoins(coins, amount - coin) + 1);
        }

        return memo[amount] = min;
    }
}
