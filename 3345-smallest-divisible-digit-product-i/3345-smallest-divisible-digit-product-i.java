class Solution {
    public int smallestNumber(int n, int t) {
        
        for(int i=n;i<= 100;i++){
            int digitProd=(int)prod(i);

            if(digitProd % t==0){
                return i;
            }
        }
        return 0;
    }
    public long prod(int n){
        int product=1;

        while(n !=0){
            int rem=n %10;
            product *=rem;
            n /=10;
        }
        return product;
    }
}