
class Solution {
    public int numberOfSubstrings(String s) {

        int n = s.length();

        int[] count = new int[3];

        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {

            // Add incoming character
            count[s.charAt(right) - 'a']++;

            // While window contains a, b and c
            while (count[0] > 0 &&
                   count[1] > 0 &&
                   count[2] > 0) {

                // Count all substrings ending at right or later
                ans += n - right;

                // Remove outgoing character
                count[s.charAt(left) - 'a']--;

                left++;
            }
        }

        return ans;
    }
}
