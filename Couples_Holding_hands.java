class Solution {
    public int minSwapsCouples(int[] row) {
        int count=0;
        for(int i=0;i<row.length-1;i+=2){
            int pat;
            if(row[i]%2==0){
                pat=row[i]+1;
            }
            else pat=row[i]-1;
            if(pat!=row[i+1]){
                count++;
                for(int j=i;j<row.length;j++){
                    if(row[j]==pat){
                        int temp=row[j];
                        row[j]=row[i+1];
                        row[i+1]=row[j];
                        break;
                    }
                }
            }
        }
        return count;
    }
}