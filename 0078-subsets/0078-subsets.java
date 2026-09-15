class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();

        getSubsets(nums,arr,0,ans);
        return ans;
    }
    public void getSubsets(int[] nums,List<Integer> arr,int i,List<List<Integer>> ans){
        if(i==nums.length){
            ans.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[i]);
        getSubsets(nums,arr,i+1,ans);

        arr.remove(arr.size()-1);
        getSubsets(nums,arr,i+1,ans);
    }
}