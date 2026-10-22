class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        fun(0,target,res,new ArrayList<>(),candidates);
        return res;
    }
    public void fun(int idx,int targ,List<List<Integer>>res,List<Integer>ans,int [] candidates){
        if(idx == candidates.length){
            if(targ == 0){
                res.add(new ArrayList<>(ans));
            }
            return;
        }
        if(targ>=candidates[idx]){
           ans.add(candidates[idx]);
           fun(idx,targ-candidates[idx],res,ans,candidates); // pick
           ans.remove(ans.size()-1);
        }
        fun(idx+1,targ,res,ans,candidates); // non-pick    
    }
}