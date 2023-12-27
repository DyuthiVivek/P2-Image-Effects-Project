#include "Flip.h"
using namespace std;

void horizontalFlip(vector<vector<Pixel>> &image) {
    // Iterate through each row of the image
    for (vector<Pixel> &row : image) {
        // Reverse the order of pixels in each row
        reverse(row.begin(), row.end());
    }
}

void verticalFlip(vector<vector<Pixel>> &image) {
    // Reverse the order of rows in the image
    reverse(image.begin(), image.end());
}
