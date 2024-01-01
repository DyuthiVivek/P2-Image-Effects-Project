package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.SharpenInterface;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class SharpenEffect implements ParameterizableEffect{
    private float sharpenAmount;
    
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "Sharpen", Float.toString(sharpenAmount));//adding the effect to logs
        return SharpenInterface.applySharpen(image, sharpenAmount);
    }

    public void setParameter(String paramName, float value) throws IllegalParameterException{
        if(value != (float)value || value < 0.0f || value > 100.0f)
            throw new IllegalParameterException();  //throwing the exception if the value is not float
        sharpenAmount = value;  //fixing the parameter value
    }
}
