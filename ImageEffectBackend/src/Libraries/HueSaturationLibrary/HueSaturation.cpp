#include "HueSaturation.h"
#include <bits/stdc++.h>
using namespace std;

void HueEffect(vector<vector<Pixel>>& image, float HueOffset){
    int height = image.size();
    int width = image[0].size();
    //accessing each pixel in the image
    for (int i = 0; i < height; i ++){
        for (int j = 0; j < width; j ++){
            image[i][j].b = (image[i][j].b + HueOffset) % 180;   //adjusting the hue
        }
    }
}

unsigned char rgbToGrayscale(const Pixel& pixel) {
    return static_cast<unsigned char>(
        0.299 * pixel.r + 0.587 * pixel.g + 0.114 * pixel.b);
}

void SaturationEffect(vector<vector<Pixel>>& image, float SatOffset){
     int height = image.size();
    int width = image[0].size();
    //accessing each pixel in the image
    for (int i = 0; i < height; i ++){
        for (int j = 0; j < width; j ++){
             unsigned char grayscale = rgbToGrayscale(image[i][j]);

        // Adjust color towards grayscale based on saturationFactor
        image[i][j].r = static_cast<unsigned char>(
            grayscale + SatOffset * (image[i][j].r - grayscale));
        image[i][j].g = static_cast<unsigned char>(
            grayscale + SatOffset * (image[i][j].g - grayscale));
        image[i][j].b = static_cast<unsigned char>(
            grayscale + SatOffset * (image[i][j].b - grayscale));
        }
    }
}