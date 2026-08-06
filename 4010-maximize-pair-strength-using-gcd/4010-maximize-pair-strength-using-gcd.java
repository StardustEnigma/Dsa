class Solution {
    public long maxPairStrength(int[] nums) {
        long maxStrength=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++){
                
                int gcd=gcd(nums[i],nums[j]);
                long strength= (1L * nums[i] * nums[j])/(gcd*gcd);

                maxStrength=Math.max(maxStrength,strength);
            }
        }
        return maxStrength;
    }
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}