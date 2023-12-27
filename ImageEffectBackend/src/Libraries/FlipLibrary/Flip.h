#ifndef FLIP_H
#define FLIP_H
#include "../Pixel.h"
#include <vector>
#include <algorithm>
using namespace std;

void horizontalFlip(vector<vector<Pixel>> &image);
void verticalFlip(vector<vector<Pixel>> &image);

#endif