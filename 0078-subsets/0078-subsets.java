import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(0, nums, new ArrayList<>(), result);
        
        return result;
    }
    
    public void backtrack(int index, int[] nums, 
                          List<Integer> current, 
                          List<List<Integer>> result) {
        
        // Add current subset
        result.add(new ArrayList<>(current));
        
        // Try adding remaining elements
        for (int i = index; i < nums.length; i++) {
            
            // Choose
            current.add(nums[i]);
            
            // Explore
            backtrack(i + 1, nums, current, result);
            
            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}