class Solution {
    public int solve(int amount,int[] coins,int[][] dp, int i){
        if(amount==0){
            return 1;
        }
        if(amount<0 || i==coins.length){
            return 0;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        if(coins[i]<=amount){
            dp[i][amount] = solve(amount-coins[i],coins,dp,i)+solve(amount,coins,dp,i+1);
            return dp[i][amount];
        }
        dp[i][amount] = solve(amount,coins,dp,i+1);
        return dp[i][amount];

    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<amount+1;j++){
                dp[i][j] = -1;
            }
        }
        //Arrays.fill(dp,-1)
        return solve(amount,coins,dp,0);
    }
}