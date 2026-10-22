class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        fun(0,res,new ArrayList<>(),nums);
        return res;
    }
    public void fun(int idx,List<List<Integer>>res,List<Integer>ans,int nums[]){
        if(idx == nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums, idx, i);

            ans.add(nums[idx]);
            fun(idx+1,res,ans,nums);
            ans.remove(ans.size()-1);

            swap(nums,idx,i);
        }
    }
    public void swap(int nums[],int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}