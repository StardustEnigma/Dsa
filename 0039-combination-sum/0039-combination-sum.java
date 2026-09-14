class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> arr= new ArrayList<>();
        int index=0;
        int sum=0;
        sum(ans,index,target,candidates,sum,arr);
        return ans;
    }
    public void sum(List<List<Integer>> ans, int index,int target,int[] candidates,int sum,List<Integer> arr){
        if(sum == target){
            ans.add(new ArrayList<>(arr));
            return;
        }
        if(sum > target ){
            return;
        }
        if(index == candidates.length){
            return;
        }       
        arr.add(candidates[index]);
        sum(ans,index,target,candidates,sum+candidates[index],arr);
        arr.remove(arr.size() - 1);
        sum(ans,index+1,target,candidates,sum,arr);
    }
}