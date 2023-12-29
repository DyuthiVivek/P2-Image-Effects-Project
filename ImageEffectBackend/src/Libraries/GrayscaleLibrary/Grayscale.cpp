#include "Grayscale.h"
#include <vector>
#include <algorithm>

using namespace std;

void convertToGrayscale(vector<vector<Pixel>>& image) {
    int height = image.size();
    int width = image[0].size();

    // Iterate through each pixel in the image
    for (int i = 0; i < height; ++i) {
        for (int j = 0; j < width; ++j) {
            // Calculate grayscale intensity by taking the average of the color channels
            int grayscale = (image[i][j].r + image[i][j].g + image[i][j].b) / 3;

            // Set the same grayscale intensity for all color channels
            image[i][j].r = image[i][j].g = image[i][j].b = grayscale;
        }
    }
}