class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int index,
                           int[] candidates,
                           int target,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // Found one combination
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Invalid path
        if (target < 0 || index == candidates.length)
            return;

        // Choice 1: Take current number
        current.add(candidates[index]);
        backtrack(index,
                  candidates,
                  target - candidates[index],
                  current,
                  ans);

        // Undo choice (Backtrack)
        current.remove(current.size() - 1);

        // Choice 2: Skip current number
        backtrack(index + 1,
                  candidates,
                  target,
                  current,
                  ans);
    }
}