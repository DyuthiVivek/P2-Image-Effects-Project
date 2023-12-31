#include "Brightness.h"
#include <vector>
#include <algorithm> // for min and max
using namespace std;



//Function to brighten the image
void brightnessImage(vector<vector<Pixel>>& image, float brightnessAmount) {
     brightnessAmount= (brightnessAmount-100)*2;
    int height = image.size();
    int width = image[0].size();
    
    // Apply brightness to each pixel in all color channels
    for (int i = 0; i < height; ++i) {
        for (int j = 0; j < width; ++j) {
            // Add the brightness amount to each channel
            image[i][j].r = min(max(image[i][j].r + (int)brightnessAmount, 0), 255);
            image[i][j].g = min(max(image[i][j].g + (int)brightnessAmount, 0), 255);
            image[i][j].b = min(max(image[i][j].b + (int)brightnessAmount, 0), 255);
        }
    }
}