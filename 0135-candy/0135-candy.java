class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int candy=n;
        int i=1;
        while(i<n){
            if(ratings[i]==ratings[i-1]){
                i++;
                continue;
            }
            int peak=0;
           while(i<n && ratings[i]>ratings[i-1]){
                i++;
                peak++;
                candy +=peak;

            }
            int dip=0;
            while(i<n && ratings[i]<ratings[i-1]){
            dip++;
            candy+=dip;
            i++;
        }
        candy-=Math.min(peak,dip);
        
    }
    
    return candy;
    }
}