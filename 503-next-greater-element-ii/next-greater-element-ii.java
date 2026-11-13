
import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Traverse the array twice, from right to left
        for (int i = 2 * n - 1; i >= 0; i--) {

            int index = i % n;

            // Remove elements that are not greater
            while (!stack.isEmpty() && stack.peek() <= nums[index]) {
                stack.pop();
            }

            // Store answer only during the first traversal
            if (i < n) {
                if (stack.isEmpty()) {
                    ans[index] = -1;
                } else {
                    ans[index] = stack.peek();
                }
            }

            // Push current element
            stack.push(nums[index]);
        }

        return ans;
    }
}
