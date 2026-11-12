
import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            // Expand: include incoming element
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0) + 1);

            // Shrink while distinct integers exceed k
            while (map.size() > k) {
                int removed = nums[left];

                map.put(removed, map.get(removed) - 1);

                if (map.get(removed) == 0) {
                    map.remove(removed);
                }

                left++;
            }

            // Count all valid subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }
}
