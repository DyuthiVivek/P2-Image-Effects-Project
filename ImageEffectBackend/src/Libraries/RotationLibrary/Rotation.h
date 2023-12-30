#ifndef ROTATION_H
#define ROTATION_H
#include "../Pixel.h"
#include <vector>
using namespace std;

void rotate90(vector<vector<Pixel>> &image);
void rotate180(vector<vector<Pixel>> &image);
void rotate270(vector<vector<Pixel>> &image);

#endif