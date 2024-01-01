#include "Rotation.h"

void rotate90(vector<vector<Pixel>> &image) {
    // Check if the image is empty or has uneven dimensions
    if (image.empty() || image[0].empty()) {
        // Handle empty image or invalid dimensions
        return;
    }

    // Get the number of rows and columns in the image
    int rows = image.size();
    int cols = image[0].size();

    // Create a temporary image to store the rotated result
    vector<vector<Pixel>> rotatedImage(cols, vector<Pixel>(rows));

    // Perform the rotation (90 degrees clockwise)
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            // Adjust indices based on rotation angle
            rotatedImage[j][rows - 1 - i] = image[i][j];
        }
    }

    // Copy the rotated image back to the original image
    image = rotatedImage;
}

void rotate180(vector<vector<Pixel>> &image) { //for 180 degree rotation we used the 90 degree rotation 2 times
    rotate90(image);
    rotate90(image);
}

void rotate270(vector<vector<Pixel>> &image) { //for 270 degree rotation we used 180 and 90 degree rotation
    rotate180(image);
    rotate90(image);
}