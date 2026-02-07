int thirdMax(int* nums, int numsSize) {
    long first = LONG_MIN;
    long second = LONG_MIN;
    long third = LONG_MIN;


    for (int i =0; i<numsSize; i++){
        int x = nums[i];

        if(x ==first || x == second || x== third)
            continue;
        
        if(x> first){
            third= second;
            second=first;
            first=x;
        }
        else if(x>second){
            third = second;
            second = x;
        }
        else if(x>third) {
            third = x;
        }
    }
     if (third == LONG_MIN)
        return (int)first;
return (int)third;

}
