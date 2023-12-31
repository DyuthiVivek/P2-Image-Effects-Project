#ifndef BRIGHTNESS_H
#define BRIGHTNESS_H
#include "../Pixel.h"
#include <vector>
#include <algorithm> // for min and max
using namespace std;
void brightnessImage(vector<vector<Pixel>>& image, float brightnessAmount);
#endif