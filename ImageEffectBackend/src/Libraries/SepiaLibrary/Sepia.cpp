#include "Sepia.h"
#include <vector>
#include <algorithm>
using namespace std;


// Function to apply sepia effect to an image
void applySepiaEffect(vector<vector<Pixel>>& image) {
    for (int i = 0; i < image.size(); ++i) {
        for (int j = 0; j < image[i].size(); ++j) {
            Pixel& pixel = image[i][j];

            int& r = pixel.r;
            int& g = pixel.g;
            int& b = pixel.b;

            // Calculate sepia values
            int sepiaR = static_cast<int>(0.393 * r + 0.769 * g + 0.189 * b);
            int sepiaG = static_cast<int>(0.349 * r + 0.686 * g + 0.168 * b);
            int sepiaB = static_cast<int>(0.272 * r + 0.534 * g + 0.131 * b);

            // Clamp values to [0, 255]
            r = min(255, sepiaR);
            g = min(255, sepiaG);
            b = min(255, sepiaB);
        }
    }
}   