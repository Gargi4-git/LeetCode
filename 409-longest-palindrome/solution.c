int longestPalindrome(char* s) {
    int freq[128] = {0};
    int length =0;
    int hasOdd = 0;

    for (int i =0; s[i]!='\0'; i++){
        freq[s[i]]++;
    }

    for (int i=0; i< 128; i++){
        if(freq[i] % 2 ==0){
            length += freq[i];
      } else{
        length += freq[i] - 1;
        hasOdd = 1;
      }
    }
    if(hasOdd){
        length +=1;
    }
    return length;
}



