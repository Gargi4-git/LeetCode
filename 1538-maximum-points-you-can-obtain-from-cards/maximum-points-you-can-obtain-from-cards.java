class Solution {
    public int maxScore(int[] cardScore, int k) {

        int n = cardScore.length;

        // Step 1: Calculate total sum
        int totalSum = 0;

        for (int num : cardScore) {
            totalSum += num;
        }

        // Step 2: Find the window size
        int windowSize = n - k;

        // If we pick all cards
        if (windowSize == 0) {
            return totalSum;
        }

        // Step 3: Calculate first window sum
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += cardScore[i];
        }

        int minWindowSum = windowSum;

        // Step 4: Slide the window
        for (int i = windowSize; i < n; i++) {

            windowSum += cardScore[i];
            windowSum -= cardScore[i - windowSize];

            minWindowSum = Math.min(minWindowSum, windowSum);
        }

        // Step 5: Maximum score
        return totalSum - minWindowSum;
    }
}