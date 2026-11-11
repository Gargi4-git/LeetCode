class Solution {
    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // Check if current index is reachable
            if (i > maxReach) {
                return false;
            }

            // Update the farthest reachable index
            maxReach = Math.max(maxReach, i + nums[i]);

            // If last index is reachable, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}