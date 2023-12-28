// #include "Sharpen.h"
// #include <vector>
// #include <algorithm> // for min and max
// using namespace std;

// // Function to sharpen the image using a Laplacian filter
// void sharpenImage(std::vector<std::vector<Pixel>>& image, float sharpenAmount) {
//     // Define a Laplacian filter kernel for sharpening
//     std::vector<std::vector<int>> kernel = {
//         {0, -1, 0},
//         {-1, 4 + static_cast<int>(sharpenAmount), -1},
//         {0, -1, 0}
//     };

//     int height = image.size();
//     int width = image[0].size();

//     // Apply convolution with the Laplacian kernel for each color channel
//     for (int i = 1; i < height - 1; ++i) {
//         for (int j = 1; j < width - 1; ++j) {
//             for (int channel = 0; channel < 3; ++channel) {
//                 float sum = 0.0;
//                 for (int ki = -1; ki <= 1; ++ki) {
//                     for (int kj = -1; kj <= 1; ++kj) {
//                         switch (channel) {
//                             case 0: // Red channel
//                                 sum += image[i + ki][j + kj].r * kernel[1 + ki][1 + kj];
//                                 break;
//                             case 1: // Green channel
//                                 sum += image[i + ki][j + kj].g * kernel[1 + ki][1 + kj];
//                                 break;
//                             case 2: // Blue channel
//                                 sum += image[i + ki][j + kj].b * kernel[1 + ki][1 + kj];
//                                 break;
//                         }
//                     }
//                 }
//                 // Clip values to be within the valid range (0 to 255)
//                 switch (channel) {
//                     case 0: // Red channel
//                         image[i][j].r = std::min(std::max(static_cast<int>(sum), 0), 255);
//                         break;
//                     case 1: // Green channel
//                         image[i][j].g = std::min(std::max(static_cast<int>(sum), 0), 255);
//                         break;
//                     case 2: // Blue channel
//                         image[i][j].b = std::min(std::max(static_cast<int>(sum), 0), 255);
//                         break;
//                 }
//             }
//         }
//     }
// }

#include "Sharpen.h"
#include <vector>
#include <algorithm> // for min and max
#include <cmath>     // for std::round
using namespace std;

// Function to sharpen the image using a modified Laplacian filter
void sharpenImage(std::vector<std::vector<Pixel>>& image, float sharpenAmount) {
    // Define a modified Laplacian filter kernel for sharpening
    std::vector<std::vector<float>> kernel = {
        {-1, -1, -1},
        {-1, 9 + sharpenAmount, -1},
        {-1, -1, -1}
    };

    int height = image.size();
    int width = image[0].size();

    // Apply convolution with the modified Laplacian kernel for each color channel
    for (int i = 1; i < height - 1; ++i) {
        for (int j = 1; j < width - 1; ++j) {
            for (int channel = 0; channel < 3; ++channel) {
                float sum = 0.0;
                for (int ki = -1; ki <= 1; ++ki) {
                    for (int kj = -1; kj <= 1; ++kj) {
                        switch (channel) {
                            case 0: // Red channel
                                sum += image[i + ki][j + kj].r * kernel[1 + ki][1 + kj];
                                break;
                            case 1: // Green channel
                                sum += image[i + ki][j + kj].g * kernel[1 + ki][1 + kj];
                                break;
                            case 2: // Blue channel
                                sum += image[i + ki][j + kj].b * kernel[1 + ki][1 + kj];
                                break;
                        }
                    }
                }
                // Clip values to be within the valid range (0 to 255)
                switch (channel) {
                    case 0: // Red channel
                        image[i][j].r = std::round(std::min(std::max(sum, 0.0f), 255.0f));
                        break;
                    case 1: // Green channel
                        image[i][j].g = std::round(std::min(std::max(sum, 0.0f), 255.0f));
                        break;
                    case 2: // Blue channel
                        image[i][j].b = std::round(std::min(std::max(sum, 0.0f), 255.0f));
                        break;
                }
            }
        }
    }
}
