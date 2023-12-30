#include "HueSaturation.h"
#include <bits/stdc++.h>
using namespace std;

void HueSaturation(vector<vector<Pixel>>& image, float HueOffset, float SatOffset){
     int height = image.size();
    int width = image[0].size();
    //accessing each pixel in the image
    for (int i = 0; i < height; i ++){
        for (int j = 0; j < width; j ++){
            image[i][j].b = (image[i][j].b + HueOffset) % 180;   //adjusting the hue
            image[i][j].g = min(255, static_cast<int>(image[i][j].g) + SatOffset);   //adjusting the saturation
        }
    }
}