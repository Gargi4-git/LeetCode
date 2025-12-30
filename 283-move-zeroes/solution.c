void moveZeroes(int* nums, int numsSize) {
    int pos = 0;  // position for next non-zero

    // Step 1: move non-zero elements forward
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] != 0) {
            nums[pos] = nums[i];
            pos++;
        }
    }

    // Step 2: fill remaining positions with zero
    while (pos < numsSize) {
        nums[pos] = 0;
        pos++;
    }
}
