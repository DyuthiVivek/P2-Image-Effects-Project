package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.RotationInterface;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;

public class RotationEffect implements DiscreteEffect {
    private int degrees = 0;

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "Rotation", "Degrees: " + Integer.toString(degrees));
        return RotationInterface.applyRotation(image, degrees);
    }

    public void selectOptionValue(String optionName, int value) throws IllegalParameterException {
        if (value == 1) {
            degrees = 90;
        }

        else if (value == 2) {
            degrees = 180;
        } 

        else if (value == 3) {
            degrees = 270;
        }
        
        else {
            degrees = 0;
        }
    }
}
