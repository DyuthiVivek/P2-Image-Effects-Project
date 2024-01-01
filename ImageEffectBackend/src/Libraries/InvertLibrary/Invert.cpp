#include "Invert.h"
#include <bits/stdc++.h>
#include <vector>

using namespace std;

void InvertImage (vector<vector<Pixel>>& image){
    int height = image.size();
    int width = image[0].size();
    //accessing each pixel in the image
    for (int i = 0; i < height; i ++){
        for (int j = 0; j < width; j ++){
            image[i][j].r = 255 - image[i][j].r;  //changing the r, g, b values
            image[i][j].g = 255 - image[i][j].g;
            image[i][j].b = 255 - image[i][j].b;
        }
    }
}
