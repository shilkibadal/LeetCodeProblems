class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteangle=6 * minutes;
       double hourangle= (hour%12)* 30+ minutes*0.5;
        double diff=Math.abs(hourangle-minuteangle);
        double minn=Math.min(diff,360-diff);
        return minn;
    }
}