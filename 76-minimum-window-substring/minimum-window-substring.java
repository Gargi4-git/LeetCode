
class Solution {
    public String minWindow(String s, String t) {

        int[] need = new int[128];

        // Count required characters
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int left = 0;
        int missing = t.length();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Include incoming character
            if (need[ch] > 0) {
                missing--;
            }

            need[ch]--;

            // When all characters are found, shrink
            while (missing == 0) {

                int windowLength = right - left + 1;

                // Update minimum window
                if (windowLength < minLength) {
                    minLength = windowLength;
                    start = left;
                }

                // Remove outgoing character
                char removed = s.charAt(left);
                need[removed]++;

                if (need[removed] > 0) {
                    missing++;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}