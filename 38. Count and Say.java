class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        if (n == 2)
            return "11";
        String ref = "11";
        for (int i = 3; i <= n; i++) {
            int a = ref.length();
            int count=1;
            String temp="";
            for(int j=0;j<a-1;j++){
                if(ref.charAt(j)==ref.charAt(j+1)) count++;
                else {
                    temp = temp + String.valueOf(count)+ref.charAt(j);
                    count=1;
                }
            }
            temp = temp + String.valueOf(count) + ref.charAt(a-1);
            ref=temp;
        }
        return ref;
    }

}