class Solution {
    private int start =0;
    private int maxLen = 1;
    public String longestPalindrome(String s) {
        if( s== null || s.length() < 2)
            return s;

        for(int i =0; i<s.length(); i++){
            expand(s, i, i);

            expand(s, i, i+1);
        }

        return s.substring(start, start + maxLen);     
    }

    public void expand(String s, int left, int right){
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        int length = right - left -1;
        if(length>maxLen){
            maxLen = length;
            start = left+1;
        } 

    }
}