
class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add incoming character
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            // Shrink while replacements needed exceed k
            while ((right - left + 1) - getMaxFrequency(freq) > k) {

                char removed = s.charAt(left);
                freq[removed - 'A']--;

                left++;
            }

            // Update answer
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    private int getMaxFrequency(int[] freq) {
        int max = 0;

        for (int count : freq) {
            max = Math.max(max, count);
        }

        return max;
    }
}
