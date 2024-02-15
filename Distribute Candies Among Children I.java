class Solution {
    public int distributeCandies(int n, int limit) {
        int count=0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                for(int k=0;k<=n-i-j;k++){
                    if(i<=limit && j<=limit && k<=limit && (i+j+k)==n){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}