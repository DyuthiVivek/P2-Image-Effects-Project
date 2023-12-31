package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.BrightnessInterface;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class BrightnessEffect implements SingleValueParameterizableEffect{
    private float brightnessAmount;
    
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "Brightness", Float.toString(brightnessAmount));
        return BrightnessInterface.applyBrightness(image, brightnessAmount);
    }

    public void setParameterValue(float value) throws IllegalParameterException{
        if(value != (float)value)
            throw new IllegalParameterException();
            brightnessAmount = value;
      
    }

}