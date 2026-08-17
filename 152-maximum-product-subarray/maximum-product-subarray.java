class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for(int i=1; i<nums.length; i++){
            int num =  nums[i];
            int oldMax = max;
            int oldMin = min;

            max = Math.max(num, Math.max(num*oldMax, num*oldMin));
             min = Math.min(num, Math.min(num * oldMax, num *oldMin));
           
             ans = Math.max(ans, max);
        }
        return ans;

    }
}