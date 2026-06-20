class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int subsets=1<<nums.length;
        for(int i=0;i<subsets;i++){
            List<Integer> a=new ArrayList<>(); 
            for(int j=0;j<nums.length;j++){
                if((i & (1<<j)) != 0){
                    a.add(nums[j]);
                }
            }
            ans.add(a);
        }
        return ans;
    }
}