#include "GaussianBlur.h"
#include <vector>
#include <algorithm>
#include <valarray>
using namespace std;
// Gaussian blur function
void applyGaussianBlur(vector<vector<Pixel>>& image, float radius) {
    int size = 2 * static_cast<int>(radius) + 1;
    float sigma = radius / 3.0f;
    vector<vector<float>> kernel(size, vector<float>(size));

    // Create Gaussian kernel
    float sum = 0.0f;
    for (int x = -static_cast<int>(radius); x <= static_cast<int>(radius); ++x) {
        for (int y = -static_cast<int>(radius); y <= static_cast<int>(radius); ++y) {
            float expVal = exp(-(x * x + y * y) / (2 * sigma * sigma));
            kernel[x + static_cast<int>(radius)][y + static_cast<int>(radius)] = expVal;
            sum += expVal;
        }
    }

    // Normalize the kernel
    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            kernel[i][j] /= sum;
        }
    }

    int nrows = image.size();
    int ncols = image[0].size();

    // Apply convolution
    vector<vector<Pixel>> result(nrows, vector<Pixel>(ncols));

    for (int i = 0; i < nrows; ++i) {
        for (int j = 0; j < ncols; ++j) {
            float r = 0.0f, g = 0.0f, b = 0.0f;

            for (int kx = -static_cast<int>(radius); kx <= static_cast<int>(radius); ++kx) {
                for (int ky = -static_cast<int>(radius); ky <= static_cast<int>(radius); ++ky) {
                    int x = i + kx;
                    int y = j + ky;

                    if (x >= 0 && x < nrows && y >= 0 && y < ncols) {
                        r += image[x][y].r * kernel[kx + static_cast<int>(radius)][ky + static_cast<int>(radius)];
                        g += image[x][y].g * kernel[kx + static_cast<int>(radius)][ky + static_cast<int>(radius)];
                        b += image[x][y].b * kernel[kx + static_cast<int>(radius)][ky + static_cast<int>(radius)];
                    }
                }
            }

            result[i][j].r = static_cast<int>(r);
            result[i][j].g = static_cast<int>(g);
            result[i][j].b = static_cast<int>(b);
        }
    }

    // Copy the result back to the original image vector
    image = result;
}