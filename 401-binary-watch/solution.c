/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

int countBits(int x){
    int count =0;
    while(x> 0){
        count +=x & 1;
        x>>=1;
    }
    return count;
}

char** readBinaryWatch(int turnedOn, int* returnSize) {
    char** result = (char**)malloc(300*sizeof(char*));
    *returnSize = 0;


    for(int hour=-0; hour<12; hour++){
        for(int minute=0; minute<60; minute++){

            int totalOn = countBits(hour) + countBits(minute);

            if(totalOn == turnedOn){
                
                result[*returnSize] = (char*)malloc(6);
                sprintf(result[*returnSize], "%d:%02d", hour, minute);

                (*returnSize)++;


            }
        }
    }
    return result;
}