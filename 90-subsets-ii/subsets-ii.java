class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        fun(0,new ArrayList<>(),res,nums);
        return res;
    }
    public void fun(int i,List<Integer>ans,List<List<Integer>>res,int nums[]){
        if(i == nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[i]);
        fun(i+1,ans,res,nums); // pick 
        ans.remove(ans.size()-1);

        int j =i+1;
        while(j < nums.length && nums[i] == nums[j]){
              j++;
        }

        fun(j,ans,res,nums); // non-pick
    }
}