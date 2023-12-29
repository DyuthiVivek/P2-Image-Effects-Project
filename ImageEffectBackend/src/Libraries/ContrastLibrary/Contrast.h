#ifndef CONTRAST_H
#define CONTRAST_H
#include "../Pixel.h"
#include <vector>
#include <algorithm> 
using namespace std;

void ApplyingContrast(vector<vector<Pixel>>& imageVector, float amount);

#endif