class Solution {
    public int divide(int dividend, int divisor) {
    double a=0;
    if(dividend==Integer.MIN_VALUE && divisor==-1){
        return Integer.MAX_VALUE;
    }
    if(divisor!=0){
        a=dividend/divisor;
    }
    return (int)a;

    }
}