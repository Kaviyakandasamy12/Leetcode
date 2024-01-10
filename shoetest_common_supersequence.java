class Solution {
    static int dp[][] = new int[1005][1005];
    static int lcs(int m,int n,String text1,String text2) {
        if(m == 0 || n == 0) {
            dp[m][n] = 0;
        }
        if(dp[m][n] != -1) return dp[m][n];
        if(text1.charAt(m-1) == text2.charAt(n-1)) {
            dp[m][n] = 1+lcs(m-1,n-1,text1,text2);
            return dp[m][n];
        }
        int a = lcs(m-1,n,text1,text2);
        int b = lcs(m,n-1,text1,text2);
        dp[m][n] = Math.max(a,b);
        return dp[m][n];
    }
    static String findlcs(String text1,String text2) {
	    int m = text1.length();
	    int n = text2.length();
	    for(int i=0;i<=m;i++) {
	        for(int j=0;j<=n;j++){
	             dp[i][j] = -1;
	        }
	    }
	    int length = lcs(m,n,text1,text2);
	    int i=m,j=n;
	    String res = "";
	    while (i> 0 && j > 0) {
	        if(text1.charAt(i-1) == text2.charAt(j-1)) {
	            res = text1.charAt(i-1)+res;
	            i--;
	            j--;
	        }
	        else if(dp[i-1][j] > dp[i][j-1]) {
	            i--;
	        }
	        else {
	            j--;
	        }
	    }
	    return res;
	    
	}
    public String shortestCommonSupersequence(String str1, String str2) {
        String ans = "";
        String lcs = findlcs(str1,str2);
        int p1=0,p2=0;
        for(int i=0;i<lcs.length();i++){
            while(str1.charAt(p1)!=lcs.charAt(i)){
                ans = ans + str1.charAt(p1++);
            }
            while(str2.charAt(p2) != lcs.charAt(i)){
                ans = ans+str2.charAt(p2++);
            }
            ans = ans+lcs.charAt(i);
            p1++;
            p2++;
        }
        if(p1 != str1.length()){
            for(int i=p1;i<str1.length();i++){
                ans=ans+str1.charAt(i);
            }
        }
        if(p2 != str2.length()){
            for(int i=p2;i<str2.length();i++){
                ans=ans+str2.charAt(i);
            }
        }
        return ans;
    }
}