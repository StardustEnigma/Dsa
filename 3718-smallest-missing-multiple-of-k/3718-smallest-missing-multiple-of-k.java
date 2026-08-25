class Solution {
    public int missingMultiple(int[] nums, int k) {
       Set<Integer> set= new HashSet<>();

       for(int i=0;i< nums.length;i++){
            set.add(nums[i]);
       } 

       for(int i=1;;i++){
        if(!set.contains(k*i)){
            return k*i;
        }
       }
    }
}