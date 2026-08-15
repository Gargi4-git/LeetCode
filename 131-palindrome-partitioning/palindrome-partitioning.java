class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        backtrack(s, 0, path, ans);

        return ans;
    }

    public void backtrack(
        String s,
        int start,
        List<String> path,
        List<List<String>> ans
    ) {

        // We have used the entire string
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // Try every possible ending position
        for (int end = start; end < s.length(); end++) {

            // Take substring from start to end
            if (isPalindrome(s, start, end)) {

                // Choose
                path.add(s.substring(start, end + 1));

                // Explore
                backtrack(s, end + 1, path, ans);

                // Undo
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}