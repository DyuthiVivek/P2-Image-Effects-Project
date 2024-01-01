# P2-Image-Effects-Project

## Flow

## Directory Structure of Backend
1. Libraries (cpp libraries)

    Source code files for all effects are in `effect.cpp` files. 

    The Java Native Interface (JNI) code (bridge between Java and C++) is in `effectInterface.cpp` files. It applies the effect to a 2D array of Pixel objects in Java. 

    ├── BrightnessLibrary
    │   ├── Brightness.cpp
    │   ├── Brightness.h
    │   ├── BrightnessInterface.cpp
    │   └── com_iiitb_imageEffectApplication_libraryInterfaces_BrightnessInterface.h
    ├── ContrastLibrary
    │   ├── com_iiitb_imageEffectApplication_libraryInterfaces_ContrastInterface.h
    │   ├── Contrast.cpp
    │   ├── Contrast.h
    │   └── ContrastInterface.cpp
    ├── DominantColorLibrary
    │   ├── com_iiitb_imageEffectApplication_libraryInterfaces_DominantColorInterface.h
    │   ├── DominantColor.cpp
    │   ├── DominantColor.h
    │   └── DominantColorInterface.cpp
    ├── FlipLibrary
    │   ├── com_iiitb_imageEffectApplication_libraryInterfaces_FlipInterface.h
    │   ├── Flip.cpp
    │   ├── Flip.h
    │   └── FlipInterface.cpp
    ├── GaussianBlurLibrary
    │   ├── com_iiitb_imageEffectApplication_libraryInterfaces_GaussianBlurInterface.h
    │   ├── GaussianBlur.cpp
    │   ├── GaussianBlur.h
    │   └── GaussianBlurInterface.cpp
    ├── GrayscaleLibrary
    │   ├── com_iiitb_imageEffectApplication_libraryInterfaces_GrayscaleInterface.h
    │   ├── Grayscale.cpp
    │   ├── Grayscale.h
    │   └── GrayscaleInterface.cpp
    ├── HueSaturationLibrary
    │   ├── com_iiitb_imageEffectApplication_libraryInterfaces_HueSaturationInterface.h
    │   ├── HueSaturation.cpp
    │   ├── HueSaturation.h
    │   └── HueSaturationInterface.cpp
    ├── InvertLibrary
    │   ├── com_iiitb_imageEffectApplication_libraryInterfaces_InvertInterface.h
    │   ├── Invert.cpp
    │   ├── Invert.h
    │   └── InvertInterface.cpp
    ├── MakefileReference.txt
    ├── Pixel.h
    ├── RotationLibrary
    │   ├── com_iiitb_imageEffectApplication_libraryInterfaces_RotationInterface.h
    │   ├── Rotation.cpp
    │   ├── Rotation.h
    │   └── RotationInterface.cpp
    ├── SepiaLibrary
    │   ├── com_iiitb_imageEffectApplication_libraryInterfaces_SepiaInterface.h
    │   ├── Sepia.cpp
    │   ├── Sepia.h
    │   └── SepiaInterface.cpp
    └── SharpenLibrary
        ├── com_iiitb_imageEffectApplication_libraryInterfaces_SharpenInterface.h
        ├── Sharpen.cpp
        ├── Sharpen.h
        └── SharpenInterface.cpp

2. Java main
    
    1. baseEffects - 
    2. controller -
    3. effectImplementation - 
    4. exception - 
    5. libraryInterfaces - 
    6. model - 
    7. service - 
    8. utils -
    9. `ImageEffectApplication.java` -  



    ├── baseEffects
    │   ├── DiscreteEffect.java
    │   ├── ParameterizableEffect.java
    │   ├── PhotoEffect.java
    │   ├── SingleValueDiscreteEffect.java
    │   └── SingleValueParameterizableEffect.java
    ├── config
    │   └── WebConfig.java
    ├── controller
    │   ├── LogController.java
    │   └── PhotoController.java
    ├── effectImplementation
    │   ├── BrightnessEffect.java
    │   ├── ContrastEffect.java
    │   ├── DominantColorEffect.java
    │   ├── FlipEffect.java
    │   ├── GaussianBlurEffect.java
    │   ├── GrayscaleEffect.java
    │   ├── HueSaturationEffect.java
    │   ├── InvertEffect.java
    │   ├── RotationEffect.java
    │   ├── SepiaEffect.java
    │   └── SharpenEffect.java
    ├── exception
    │   └── IllegalParameterException.java
    ├── ImageEffectApplication.java
    ├── libraryInterfaces
    │   ├── BrightnessInterface.class
    │   ├── BrightnessInterface.java
    │   ├── ContrastInterface.class
    │   ├── ContrastInterface.java
    │   ├── DominantColorInterface.class
    │   ├── DominantColorInterface.java
    │   ├── FlipInterface.class
    │   ├── FlipInterface.java
    │   ├── GaussianBlurInterface.class
    │   ├── GaussianBlurInterface.java
    │   ├── GrayscaleInterface.class
    │   ├── GrayscaleInterface.java
    │   ├── HueSaturationInterface.class
    │   ├── HueSaturationInterface.java
    │   ├── InvertInterface.class
    │   ├── InvertInterface.java
    │   ├── LoadNativeLibrary.class
    │   ├── LoadNativeLibrary.java
    │   ├── Pixel.class
    │   ├── Pixel.java
    │   ├── RotationInterface.class
    │   ├── RotationInterface.java
    │   ├── SepiaInterface.class
    │   ├── SepiaInterface.java
    │   ├── SharpenInterface.class
    │   └── SharpenInterface.java
    ├── model
    │   └── LogModel.java
    ├── service
    │   ├── LoggingService.java
    │   ├── logs
    │   └── PhotoEffectService.java
    └── utils
        └── ProcessingUtils.java


## Effect source code

6. GrayScale

    For each pixel, the function calculates the grayscale intensity by taking the average of the red (r), green (g), and blue (b) color channels: grayscale = (r + g + b) / 3.

11. Sharpen

    Image sharpening is achieved using a custom 5x5 Laplacian filter. The center element (2,2) is adjusted based on the scaled `sharpenAmount`. Convolution is then applied individually for each color channel (red, green, blue). The operation is performed within a margin of 2 pixels around the image (from (2,2) to (height-3,width-3)) to fully apply the kernel.


## Logging Service

The code uses file handling to read and write `LogModel` objects to a binary file, `logs`.

1. `addLog` Function:

    It creates a timestamp and initializes a LogModel object. Writes the existing log entries back to the file and appends the new log entry to the end of the file.

2. `getAllLogs` Function:

    Reads all LogModel objects from the binary file until the end of the file is reached. Adds each read log entry to a List ad return it.

3. `getLogsByEffect` Function:

    Calls getAllLogs to get all log entries.
    Iterates through the list and selects log entries with a specific effect name.
    Returns a new list containing log entries with the specified effect name.

4. `clearLogs` Function:

    Opens the file in write mode, effectively clearing its contents.

5. `getLogsBetweenTimestamps` Function:

    Calls getAllLogs to retrieve all log entries. Converts log timestamps from string to LocalDateTime format, and returns a new list containing log entries within the specified time range.

## Contributions

1. Dyuthi Vivek - IMT2022523
    GrayScale, Sharpen effects and Logging
