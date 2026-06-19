class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int highest=0;
        int[] alt=new int[n+1];
         alt[0]=0;
        for(int i=1;i<=n;i++){
         if(i==1){
         alt[i]= gain[i-1]+alt[0];
          }
            else{
                alt[i]=alt[i-1]+gain[i-1];
            }
        }
        for(int i=0;i<=n;i++){
            if(alt[i]>highest){
                highest=alt[i];

            }
        }
        return highest;
    }
}