class Solution {
    public String addBinary(String a, String b) {
        int n1 = a.length()-1;
        int n2 = b.length()-1;
        String res="";
        int carry=0;
        while(n1>=0 || n2>=0){
            int c1=0,c2=0,sum=0;
            if(n1>=0){
                c1=(int)a.charAt(n1--)-'0';
            }
            if(n2>=0){
                c2=(int)b.charAt(n2--)-'0';
            }
            sum=carry+c1+c2;
            if(sum>1){
                carry=1;
                if(sum==2) res = '0'+res;
                else res = '1'+res;
            }
            else {
                carry=0;
                if(sum==1) res = '1'+res;
                else res = '0'+res;
            }
        }
        if(carry!=0) res = '1'+res;
        return res;
    }
}