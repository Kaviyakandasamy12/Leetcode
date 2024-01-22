class Solution {
    public void solve(int[] nums,List<List<Integer>> res, List<Integer> sub,boolean[] state){
        if(sub.size()==nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }
        if(state[0]==false){
            state[0]=true;
            sub.add(nums[0]);
            solve(nums,res,sub,state);
            state[0]=false;
            sub.remove(sub.size()-1);
        }
        for(int i=1;i<nums.length;i++){
            if(state[i]==false && nums[i]!=nums[i-1]){
                state[i]=true;
                sub.add(nums[i]);
                solve(nums,res,sub,state);
                state[i]=false;
                sub.remove(sub.size()-1);
            }
            else if(state[i]==false && nums[i]==nums[i-1]&&state[i-1]==true ){
                state[i]=true;
                sub.add(nums[i]);
                solve(nums,res,sub,state);
                state[i]=false;
                sub.remove(sub.size()-1);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        boolean[] state = new boolean[nums.length];
        Arrays.sort(nums);
        solve(nums,res,sub,state);
        return res;
    }
}