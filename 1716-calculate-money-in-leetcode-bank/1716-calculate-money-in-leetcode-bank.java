class Solution {
    public int totalMoney(int n) {
        int money=0;
        int next=1; 
       for(int i=1;i<=n;i++){
        money+=next+(i-1)%7;
       if(i%7==0){
        next++;
       }
       }
       return money;
    }
}