package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.FlipInterface;
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
        if (optionName.equals("90°") && value == 1) {
            degrees = 90;
        }

        else if (optionName.equals("180°") && value == 1) {
            degrees = 180;
        } 

        else if (optionName.equals("270°") && value == 1) {
            degrees = 270;
        }
        
        else {
            degrees = 0;
        }
    }
}
