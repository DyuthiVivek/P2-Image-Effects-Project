package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.SharpenInterface;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class SharpenEffect implements ParameterizableEffect{
    private float sharpenAmount;
    
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "Sharpen", Float.toString(sharpenAmount));
        return SharpenInterface.applySharpen(image, sharpenAmount);
    }

    public void setParameter(String paramName, float value) throws IllegalParameterException{
        if(value != (float)value)
            throw new IllegalParameterException();
        sharpenAmount = value;
        
    }
}
