class Solution {
    int maxCoins = 0;
    int memo[];
    public int coinChange(int[] coins, int amount) {
        maxCoins = amount + 1;
        memo = new int[amount+1];
        Arrays.fill(memo, maxCoins+1);
        int res = countFewCoins(coins, amount); 
        return res == maxCoins ? -1 : res; 
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
