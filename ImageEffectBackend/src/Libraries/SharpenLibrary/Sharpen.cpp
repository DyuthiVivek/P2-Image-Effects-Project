// #include "Sharpen.h"
// #include <vector>
// #include <algorithm> // for min and max
// #include <cmath>     // for std::round
// using namespace std;

// // Function to sharpen the image using a modified Laplacian filter
// void sharpenImage(std::vector<std::vector<Pixel>>& image, float sharpenAmount) {
//     // Define a modified Laplacian filter kernel for sharpening
//             sharpenAmount = ((sharpenAmount*2)+100)/100;

//     std::vector<std::vector<float>> kernel = {
//         {-1, -1, -1},
//         {-1, 9 + sharpenAmount, -1},
//         {-1, -1, -1}
//     };

//     int height = image.size();
//     int width = image[0].size();

//     // Apply convolution with the modified Laplacian kernel for each color channel
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
//                         image[i][j].r = std::round(std::min(std::max(sum, 0.0f), 255.0f));
//                         break;
//                     case 1: // Green channel
//                         image[i][j].g = std::round(std::min(std::max(sum, 0.0f), 255.0f));
//                         break;
//                     case 2: // Blue channel
//                         image[i][j].b = std::round(std::min(std::max(sum, 0.0f), 255.0f));
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

// Function to sharpen the image using a custom Laplacian filter
void sharpenImage(std::vector<std::vector<Pixel>>& image, float sharpenAmount) {

    // Scale sharpenAmount to a factor between 0 and 1 with reduced intensity
    float scaleFactor = sharpenAmount / 200.0f;

    // Define the custom Laplacian filter kernel for sharpening
    std::vector<std::vector<float>> kernel = {
        {-1, -1, -1, -1, -1},
        {-1,  2,  2,  2, -1},
        {-1,  2,  1 + scaleFactor,  2, -1},
        {-1,  2,  2,  2, -1},
        {-1, -1, -1, -1, -1}
    };

    int height = image.size();
    int width = image[0].size();

    // Temporary image to store the sharpened result
    std::vector<std::vector<Pixel>> sharpened = image;

    // Apply convolution with the custom Laplacian kernel for each color channel
    for (int i = 2; i < height - 2; ++i) {
        for (int j = 2; j < width - 2; ++j) {
            for (int channel = 0; channel < 3; ++channel) {
                float sum = 0.0;
                for (int ki = -2; ki <= 2; ++ki) {
                    for (int kj = -2; kj <= 2; ++kj) {
                        switch (channel) {
                            case 0: // Red channel
                                sum += image[i + ki][j + kj].r * kernel[2 + ki][2 + kj];
                                break;
                            case 1: // Green channel
                                sum += image[i + ki][j + kj].g * kernel[2 + ki][2 + kj];
                                break;
                            case 2: // Blue channel
                                sum += image[i + ki][j + kj].b * kernel[2 + ki][2 + kj];
                                break;
                        }
                    }
                }
                // Optionally, clip values to be within the valid range (0 to 255)
                float result = std::min(std::max(sum, 0.0f), 255.0f);

                // Update the sharpened image
                switch (channel) {
                    case 0: // Red channel
                        sharpened[i][j].r = std::round(result);
                        break;
                    case 1: // Green channel
                        sharpened[i][j].g = std::round(result);
                        break;
                    case 2: // Blue channel
                        sharpened[i][j].b = std::round(result);
                        break;
                }
            }
        }
    }

    // Copy the sharpened result back to the original image
    image = std::move(sharpened);
}
