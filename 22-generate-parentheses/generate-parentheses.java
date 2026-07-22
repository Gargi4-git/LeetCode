class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(StringBuilder current, int open, int close,  int n){
        if(current.length() == 2*n){
            ans.add(current.toString());
            return;
        }
        if(open<n){
            current.append('(');
            backtrack(current, open+1, close, n);
            current.deleteCharAt(current.length()-1);
        }
        if(close< open){
            current.append(')');

            backtrack(current, open, close + 1, n);

            current.deleteCharAt(current.length() - 1);

        }
    }
}