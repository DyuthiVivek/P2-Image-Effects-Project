#include "DominantColor.h"
using namespace std;

void fillWithDominantColor(vector<vector<Pixel>> &image) {
    // Use an unordered_map to count occurrences of each color
    unordered_map<int, int> colorCount;

    // Iterate through all pixels in the image
    for (const auto &row : image) {
        for (const auto &pixel : row) {
            // Convert RGB values to a unique identifier (e.g., concatenate them)
            int colorIdentifier = (pixel.r << 16) | (pixel.g << 8) | pixel.b;

            // Increment the count for this color
            colorCount[colorIdentifier]++;
        }
    }

    // Find the color with the highest count
    int maxCount = 0;
    int dominantColorIdentifier = 0;

    for (const auto &entry : colorCount) {
        if (entry.second > maxCount) {
            maxCount = entry.second;
            dominantColorIdentifier = entry.first;
        }
    }

    // Extract RGB values from the dominant color identifier
    Pixel dominantColor;
    dominantColor.r = (dominantColorIdentifier >> 16) & 0xFF;
    dominantColor.g = (dominantColorIdentifier >> 8) & 0xFF;
    dominantColor.b = dominantColorIdentifier & 0xFF;

    // Replace all pixels in the original image with the dominant color
    for (auto &row : image) {
        for (auto &pixel : row) {
            pixel = dominantColor;
        }
    }
}
