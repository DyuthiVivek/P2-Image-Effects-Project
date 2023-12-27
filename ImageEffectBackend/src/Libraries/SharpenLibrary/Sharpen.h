#ifndef SHARPEN_H
#define SHARPEN_H
#include "../Pixel.h"

#include <vector>
#include <algorithm> 
using namespace std;

void sharpenImage(vector<vector<Pixel>>& image, float sharpenAmount);

#endif