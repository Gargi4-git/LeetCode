
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0;
        int oddCount = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            // Expand: include the incoming element
            if (nums[right] % 2 != 0) {
                oddCount++;
            }

            // Shrink: restore the condition
            while (oddCount > k) {
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }

            // Count all valid subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }
}
