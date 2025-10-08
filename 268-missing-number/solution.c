int missingNumber(int* nums, int numsSize) {
    int expectedSum = numsSize * (numsSize + 1) / 2;  // Sum of 0..n
    int actualSum = 0;

    for (int i = 0; i < numsSize; i++) {
        actualSum += nums[i];  // Sum of array elements
    }

    return expectedSum - actualSum;  // Missing number
}
