#include "Contrast.h"
#include <vector>
#include <algorithm> 
#include <valarray>
#include <iostream>
using namespace std;
void ApplyingContrast(vector<vector<Pixel>>& imageVector, float amount){
    amount = (amount/100);
    for (size_t i = 0; i < imageVector.size(); ++i) {
        for (size_t j = 0; j < imageVector[i].size(); ++j) {
            Pixel &pixel = imageVector[i][j];

            // Applying contrast adjustment formula to each color channel (r, g, b)
            pixel.r = static_cast<int>((amount * (pixel.r - 128)) + 128);
            pixel.g = static_cast<int>((amount * (pixel.g - 128)) + 128);
            pixel.b = static_cast<int>((amount * (pixel.b - 128)) + 128);

            // Ensure pixel values are within the valid range (0-255)
            pixel.r = max(0, min(255, pixel.r));
            pixel.g = max(0, min(255, pixel.g));
            pixel.b = max(0, min(255, pixel.b));
        }
    }
}