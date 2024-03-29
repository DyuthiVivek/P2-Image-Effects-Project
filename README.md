# P2-Image-Effects-Project

This project is used to implement different effects on images using C++, Java and java wrapper.

The following effects were implemented:
- Hue - Saturation
- Brightness
- Contrast
- Flip 
- Gaussian Blur
- Grayscale
- Invert
- Rotation 
- Sepia
- Sharpen
- Dominant Color

## Usage
 For frontend:
    Track to the project directory and run `npm i`.
    Track to the folder `ImageEffectFrontend`, run `npm i` and then use the command `npm start`.

 For backend:
    Track to the folder `ImageEffectBackend` and use the following commands.
    
    make clean
    make
    ./mvnw clean package
    java -jar target/imageEffectApplication-0.0.1-SNAPSHOT.jar 




## Flow

Frontend - User interacts with the frontend layer through a browser, which runs JavaScript code written using Angular framework.

Backend - Node.js talks to Java services implemented using the Spring Boot microservice framework. The source code for image effects is written in C++. The Java services layer talks to the C++ libraries using JNI. 

## Backend Directory Structure
1. Libraries (cpp libraries)

    Source code files for all effects are in `effect.cpp` files. 

    The Java Native Interface (JNI) code (bridge between Java and C++) is in `effectInterface.cpp` files. It applies the effect to a 2D array of Pixel objects in Java. 

    ├── BrightnessLibrary<br>
    │   ├── Brightness.cpp<br>
    │   ├── Brightness.h<br>
    │   ├── BrightnessInterface.cpp<br>
    │   └── com_iiitb_imageEffectApplication_libraryInterfaces_BrightnessInterface.h<br>
    ├── ContrastLibrary<br>
    │   ├── com_iiitb_imageEffectApplication_libraryInterfaces_ContrastInterface.h<br>
    │   ├── Contrast.cpp<br>
    │   ├── Contrast.h<br>
    │   └── ContrastInterface.cpp<br>
    ├── DominantColorLibrary<br>
    │   ├── com_iiitb_imageEffectApplication_libraryInterfaces_DominantColorInterface.h<br>
    │   ├── DominantColor.cpp<br>
    │   ├── DominantColor.h<br>
    │   └── DominantColorInterface.cpp<br>
    ├── FlipLibrary<br>
    │   ├── com_iiitb_imageEffectApplication_libraryInterfaces_FlipInterface.h<br>
    │   ├── Flip.cpp<br>
    │   ├── Flip.h<br>
    │   └── FlipInterface.cpp<br>
    .<br>
    .<br>
    .<br>
    
2. Java main
    
    1. baseEffects - Contains interfaces for different types of effects (such as those with discrete/float parameter values as well as single/multiple parameters)
    2. controller - Reads parameters from the service request, calls the required Java functions from PhotoEffectService.java or LoggingService.java and returns the output
    3. effectImplementation - Implementation of the interfaces defined in baseEffects for each image effect
    4. exception - Definition of the IllegalParameterException class
    5. libraryInterfaces - Interface to the native C++ method to apply the effects
    6. model - Contains definition of the LogModel class, which defines how the logs are to be saved
    7. service - Contains PhotoEffectService.java (calls the apply function of each effect) and LoggingService.java (deals with logs)
    8. utils - Contains functions to process the image
    9. `ImageEffectApplication.java` - main to run Spring Boot application

    ├── baseEffects<br>
    │   ├── DiscreteEffect.java<br>
    │   ├── ParameterizableEffect.java<br>
    │   ├── PhotoEffect.java<br>
    │   ├── SingleValueDiscreteEffect.java<br>
    │   └── SingleValueParameterizableEffect.java<br>
    ├── config<br>
    │   └── WebConfig.java<br>
    ├── controller<br>
    │   ├── LogController.java<br>
    │   └── PhotoController.java<br>
    ├── effectImplementation<br>
    │   ├── BrightnessEffect.java<br>
    │   ├── ContrastEffect.java<br>
    │   ├── DominantColorEffect.java<br>
    │   ├── FlipEffect.java<br>
    │   ├── GaussianBlurEffect.java<br>
    │   ├── GrayscaleEffect.java<br>
    │   ├── HueSaturationEffect.java<br>
    │   ├── InvertEffect.java<br>
    │   ├── RotationEffect.java<br>
    │   ├── SepiaEffect.java<br>
    │   └── SharpenEffect.java<br>
    ├── exception<br>
    │   └── IllegalParameterException.java<br>
    ├── ImageEffectApplication.java<br>
    ├── libraryInterfaces<br>
    │   ├── BrightnessInterface.class<br>
    │   ├── BrightnessInterface.java<br>
    │   ├── ContrastInterface.class<br>
    │   ├── ContrastInterface.java<br>
    │   ├── DominantColorInterface.class<br>
    │   ├── DominantColorInterface.java<br>
    │   ├── FlipInterface.class<br>
    │   ├── FlipInterface.java<br>
    │   .<br>
    │   .<br>
    │   .<br>
    ├── model<br>
    │   └── LogModel.java<br>
    ├── service<br>
    │   ├── LoggingService.java<br>
    │   ├── logs<br>
    │   └── PhotoEffectService.java<br>
    └── utils<br>
        └── ProcessingUtils.java<br>



## Effect source code
1. Hue Saturation

   For each pixel, the r, g, b values are converted into h (Hue), s (Saturation), v (Value) system and the hue and saturation are updated according to the hue and saturation offset values as follows

   h += HueOffset
   s *= SaturationOffset

   and the h, s, v values are again converted back into the r, g, b system and applied to the image.

2. Brightness

   For each pixel in the image vector,the r,g,b values are incremented/decremented by the brightness amount taken as input
   
   image[i][j].r = min(max(image[i][j].r + (int)brightnessAmount, 0), 255);

   -> Same is applied for g and b channels.

3. Contrast

   The function applies the contrast formula for each pixel  iterating through the image vector

   pixel.r = static_cast<int>((amount * (pixel.r - 128)) + 128);

   The amount  is the contrast amount taken as input and the formula is applied for g and b values as well to give the output image.
   It ensures that the adjusted pixel values stay within the valid range of 0 to 255 by using the min and max functions. 

5. GaussianBlur 

    The function performs a convolution operation on the input image using the generated Gaussian kernel.
    The Gaussian kernel is based on the specified radius and sigma value. 
    It calculates new pixel values for each channel (r, g, b) by considering neighboring pixels' contributions, weighted by the values in the Gaussian kernel.
    The resulting blurred image is stored in a separate 2D pixel vector which is copied to the image back.
   
7. Dominant Color

    The dominant color function uses an unordered map to count the number of occurrences of each color. It then fills the image with the color that has the maximum number of occurrences.

8. Flip

    This was accomplished using two functions, `horizontalFlip` and `verticalFlip`. 
    - Vertical flip reverses the order of rows in the 2D vector.
    - Horizontal flip reverses the order of elements in each row.

9. GrayScale

    For each pixel, the function calculates the grayscale intensity by taking the average of the red (r), green (g), and blue (b) color channels: grayscale = (r + g + b) / 3.
10. Invert

   For each pixel in the input image, the function calculates the invert value of each channel (red, green and blue) i.e., 255 - (actual channel value).

11. Sepia

   For each pixel in the image, r,g,b values are updated  to :
    
    - sepiaR = 0.393 * r + 0.769 * g + 0.189 * b;
    - sepiaG = 0.349 * r + 0.686 * g + 0.168 * b;
    - sepiaB = 0.272 * r + 0.534 * g + 0.131 * b;
   
   Then the values are clamped to [0,255]
   
10. Rotation

    The rotation effect is implemented by creating a new matrix that places every pixel in the appropriate location to do a 90 degree rotation. 180 degree and 270 degree rotations are performed by repeatedly calling the 90 degree rotation.

11. Sharpen

    Image sharpening is achieved using a custom 5x5 Laplacian filter. The center element (2,2) is adjusted based on the scaled `sharpenAmount`. Convolution is then applied individually for each color channel (red, green, blue). The operation is performed within a margin of 2 pixels around the image (from (2,2) to (height-3,width-3)) to fully apply the kernel.


## Logging Service

We are maintaining logs using file handling to read and write `LogModel` objects to a binary file, `logs`.

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

    GrayScale, Sharpen, Logging

2. Swetha Murali - IMT2022018

    Flip, Rotation, Dominant Color

3. Akshaya Bysani - IMT2022579

    Hue Saturation and Invert

4. Niveditha Varma - IMT2021033

    Brightness and Sepia
   
5. PVS Sukeerthi - IMT2022572

   Contrast and GaussianBlur
   
