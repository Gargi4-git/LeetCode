#include <stdbool.h>
#include <string.h>

bool wordPattern(char* pattern, char* s) {
    char* map[26] = {NULL};

    char sCopy[3001];
    strcpy(sCopy, s);

    char* word = strtok(sCopy, " ");
    int i = 0;

    while (pattern[i] != '\0') {
        if (word == NULL)
            return false;

        int idx = pattern[i] - 'a';

        if (map[idx] == NULL) {
            for (int j = 0; j < 26; j++) {
                if (map[j] && strcmp(map[j], word) == 0)
                    return false;
            }
            map[idx] = word;
        } else {
            if (strcmp(map[idx], word) != 0)
                return false;
        }

        word = strtok(NULL, " ");
        i++;
    }

    if (word != NULL)
        return false;

    return true;
}
