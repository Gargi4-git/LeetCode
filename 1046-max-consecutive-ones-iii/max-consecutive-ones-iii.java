class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeros = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add incoming element
            if (nums[right] == 0) {
                zeros++;
            }

            // Shrink while window is invalid
            while (zeros > k) {

                if (nums[left] == 0) {
                    zeros--;
                }

                left++;
            }

            // Record maximum valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}