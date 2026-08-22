class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int pro=1;
        int p=n;
        while(n>0)
        {
        int r=n%10;
        sum+=r;
        pro*=r;
        n=n/10;
        }
        int total=sum+pro;
        return p%total==0;
    }
}