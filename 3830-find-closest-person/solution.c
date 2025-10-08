#include <stdlib.h>  // for abs()

int findClosest(int x, int y, int z) {
    int dist1 = abs(x - z);  // Distance between Person 1 and Person 3
    int dist2 = abs(y - z);  // Distance between Person 2 and Person 3

    if (dist1 < dist2)
        return 1;  // Person 1 reaches first
    else if (dist1 > dist2)
        return 2;  // Person 2 reaches first
    else
        return 0;  // Both reach at same time
}
