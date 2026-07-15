class Solution {
    public int gcdOfOddEvenSums(int n) {
            int sumOdd=0;
            int sumEven=0;
for(int i=1;i<2*n;i+=2){
 sumOdd+=i;
}
       for(int i=2;i<=2*n;i+=2){
        sumEven+=i;
       }
        return gcd(sumOdd,sumEven);
    }
       private int gcd(int sumOdd,int sumEven){
        while(sumEven>0){
        int temp=sumEven;
         sumEven=sumOdd%sumEven;
         sumOdd=temp;

              }
              return sumOdd;
       }
    
        
    }
