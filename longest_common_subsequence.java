class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return lcs(m,n,text1,text2,dp);
    }
    public int lcs(int m,int n, String text1, String text2,int[][] dp){
        if(n==0 || m==0) return 0;
        if(text1.charAt(m-1)==text2.charAt(n-1)) return 1+lcs(m-1,n-1,text1,text2,dp);
        int a,b;
        if(dp[m-1][n]!=-1) a=dp[m-1][n];
        else {
            a = lcs(m-1,n,text1,text2,dp);
            dp[m-1][n]=a;
        }
        if(dp[m][n-1]!=-1) b = dp[m][n-1];
        else{
           b = lcs(m,n-1,text1,text2,dp);
           dp[m][n-1] = b; 
        }
        return Math.max(a,b);
    }
}