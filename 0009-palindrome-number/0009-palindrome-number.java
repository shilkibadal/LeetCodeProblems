class Solution {
    public boolean isPalindrome(int x) {
        int n=x;
        int pal=0;
        while(x>0)
        {
            int r=x%10;
            pal=pal*10+r;
            x=x/10;
        }
        if(n==pal)
        {
            return true;
        }
       return  false;
    }
}