class Solution {
    public long minimumPerimeter(long neededApples) {
        long count = 0;
        long sum = 0;

        while (sum < neededApples) {
            count++;
            sum += 12L * count * count;
        }

        return 8L * count;
    }
}