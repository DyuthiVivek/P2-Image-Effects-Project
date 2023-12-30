#include "HueSaturation.h"
#include <bits/stdc++.h>
using namespace std;

void rgbToHsv(unsigned char r, unsigned char g, unsigned char b, double& h, double& s, double& v) {
    double minVal = std::min(std::min(r, g), b);
    double maxVal = std::max(std::max(r, g), b);
    double delta = maxVal - minVal;

    // Calculate hue
    if (delta == 0) {
        h = 0;
    } else if (maxVal == r) {
        h = 60 * fmod(((g - b) / delta), 6);
    } else if (maxVal == g) {
        h = 60 * (((b - r) / delta) + 2);
    } else if (maxVal == b) {
        h = 60 * (((r - g) / delta) + 4);
    }

    // Calculate saturation
    s = (maxVal == 0) ? 0 : (delta / maxVal);

    // Set value
    v = maxVal;
}

void hsvToRgb(double h, double s, double v, unsigned char r, unsigned char g, unsigned char b) {
    double c = v * s;
    double x = c * (1 - std::abs(fmod(h / 60.0, 2) - 1));
    double m = v - c;

    double red, green, blue;
    if (h >= 0 && h < 60) {
        red = c;
        green = x;
        blue = 0;
    } else if (h >= 60 && h < 120) {
        red = x;
        green = c;
        blue = 0;
    } else if (h >= 120 && h < 180) {
        red = 0;
        green = c;
        blue = x;
    } else if (h >= 180 && h < 240) {
        red = 0;
        green = x;
        blue = c;
    } else if (h >= 240 && h < 300) {
        red = x;
        green = 0;
        blue = c;
    } else {
        red = c;
        green = 0;
        blue = x;
    }

    r = static_cast<unsigned char>((red + m) * 255);
    g = static_cast<unsigned char>((green + m) * 255);
    b = static_cast<unsigned char>((blue + m) * 255);
}

void HueEffect(vector<vector<Pixel>>& image, float HueOffset){
    int height = image.size();
    int width = image[0].size();
    //accessing each pixel in the image
    for (int i = 0; i < height; i ++){
        for (int j = 0; j < width; j ++){
             double h, s, v;
            rgbToHsv(image[i][j].r, image[i][j].g, image[i][j].b, h, s, v);   // Adjust the hue
            h = fmod((h + HueOffset + 360), 360);
            hsvToRgb(h, s, v, image[i][j].r, image[i][j].g, image[i][j].b);
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