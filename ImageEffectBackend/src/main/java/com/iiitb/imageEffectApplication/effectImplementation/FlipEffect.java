package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.FlipInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;

public class FlipEffect implements DiscreteEffect{
    private int horizontalFlipValue = 0, verticalFlipValue = 0;

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        return FlipInterface.applyFlip(image, horizontalFlipValue, verticalFlipValue);
    }

    public void selectOptionValue(String optionName, int value) throws IllegalParameterException {
        if (optionName.equals("Horizontal")) {
            horizontalFlipValue = value;
        } else if (optionName.equals("Vertical")) {
            verticalFlipValue = value;
        } else {
            throw new IllegalParameterException();
        }
    }

}
