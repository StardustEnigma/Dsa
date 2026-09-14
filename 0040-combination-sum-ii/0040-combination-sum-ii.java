class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(candidates);
        int index=0;
        int sum=0;
        combination(ans,arr,candidates,target,index,sum);

        return ans;
    }
    public void combination(List<List<Integer>> ans, List<Integer> arr,int[] candidates,int target,int index,int sum){
        if(sum == target){
            ans.add(new ArrayList<>(arr));
            return;
        }
        if(sum > target || index == candidates.length){
            return;
        }
        for(int i=index; i <candidates.length;i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            arr.add(candidates[i]);
            combination(ans,arr,candidates,target,i+1,sum+candidates[i]);
            arr.remove(arr.size()-1);
        }
    }
}