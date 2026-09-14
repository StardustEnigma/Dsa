class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> arr= new ArrayList<>();
        int num=1;
        int sum=0;
        combination(ans,arr,k,n,sum,num);
        return ans;
    }

    public void combination(List<List<Integer>> ans, List<Integer> arr,int k, int n, int sum,int num){

        if(arr.size()==k && sum==n){
            ans.add(new ArrayList<>(arr));
            return;
        }
        if(arr.size() == k || sum > n || num > 9){
            return;
        }
        arr.add(num);
        combination(ans,arr,k,n,sum+num,num+1);
        arr.remove(arr.size()-1);

        combination(ans,arr,k,n,sum,num+1);
    }
}