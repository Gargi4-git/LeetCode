class Solution {

    List <String> ans = new ArrayList<>();
    String[] phone = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs",
        "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if(digits.length() ==0)
            return ans;
        backtrack(digits, 0, new StringBuilder());

        return ans;
    }


    private void backtrack(String digits, int index, StringBuilder current){
        if (index == digits.length()){
            ans.add(current.toString());
             return;
        }
        String letters = phone[digits.charAt(index) - '0'];
        for(int i =0; i < letters.length(); i++){
            current.append(letters.charAt(i));
            backtrack(digits, index+1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}