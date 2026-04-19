class Solution {
    public int findComplement(int num) {
        int mask = 1;

        while(mask<=num && mask > 0){
          mask = mask << 1;

        }

        mask = mask - 1;
        
        return mask ^ num;
    }
}