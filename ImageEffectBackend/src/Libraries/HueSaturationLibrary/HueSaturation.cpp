#include "HueSaturation.h"
#include <bits/stdc++.h>
using namespace std;

void rgbToHsv(int r, int g, int b, double& h, double& s, double& v) {
    double fr = r / 255.0;
    double fg = g / 255.0;
    double fb = b / 255.0;

    double cmax = std::max({fr, fg, fb});
    double cmin = std::min({fr, fg, fb});
    double delta = cmax - cmin;

    // Hue calculation
    if (delta == 0) {
        h = 0;
    } else if (cmax == fr) {
        h = 60 * std::fmod(((fg - fb) / delta), 6);
    } else if (cmax == fg) {
        h = 60 * (((fb - fr) / delta) + 2);
    } else if (cmax == fb) {
        h = 60 * (((fr - fg) / delta) + 4);
    }

    // Saturation calculation
    s = (cmax == 0) ? 0 : (delta / cmax);

    // Value calculation
    v = cmax;
}

// Convert HSV to RGB
void hsvToRgb(double h, double s, double v, int& r, int& g, int& b) {
    h = std::fmod(h, 360);
    if (h < 0) {
        h += 360;
    }

    double c = v * s;
    double x = c * (1 - std::fabs(std::fmod(h / 60, 2) - 1));
    double m = v - c;

    double rp, gp, bp;
    if (h < 60) {
        rp = c;
        gp = x;
        bp = 0;
    } else if (h < 120) {
        rp = x;
        gp = c;
        bp = 0;
    } else if (h < 180) {
        rp = 0;
        gp = c;
        bp = x;
    } else if (h < 240) {
        rp = 0;
        gp = x;
        bp = c;
    } else if (h < 300) {
        rp = x;
        gp = 0;
        bp = c;
    } else {
        rp = c;
        gp = 0;
        bp = x;
    }

    r = static_cast<int>((rp + m) * 255);
    g = static_cast<int>((gp + m) * 255);
    b = static_cast<int>((bp + m) * 255);
}

void HueSaturationEffect(vector<vector<Pixel>>& image, float HueOffset, float SatOffset){
    HueOffset = (HueOffset*2)-100;
    SatOffset = (SatOffset/100);
    
    int height = image.size();
    int width = image[0].size();
    //accessing each pixel in the image
    for (int i = 0; i < height; i ++){
        for (int j = 0; j < width; j ++){
             double h, s, v;
             rgbToHsv(image[i][j].r, image[i][j].g, image[i][j].b, h, s, v); 
        
              
             // Adjust the hue
            //h = fmod((h + HueOffset + 360), 360);
            h += HueOffset;
            s *= SatOffset;
            hsvToRgb(h, s, v, image[i][j].r, image[i][j].g, image[i][j].b);
        }   
    }
}

