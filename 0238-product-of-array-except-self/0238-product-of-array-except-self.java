class Solution {
    public int[] productExceptSelf(int[] nums) {
        int rightprod=1;
        int leftprod=1;
        int n=nums.length;
        int[] ans=new int[n];
         for(int i=n-1;i>=0;i--){
            ans[i]=rightprod;
            rightprod=rightprod*nums[i];
         }
         for(int i=0;i<n;i++){
            ans[i]=ans[i]*leftprod;
            leftprod=leftprod*nums[i];
         }
         return ans;

        
    }
}