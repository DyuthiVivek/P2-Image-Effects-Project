package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.GaussianBlurInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class GaussianBlurEffect implements SingleValueParameterizableEffect{
    private float amount;
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "GaussianBlur", Float.toString(amount));
        return GaussianBlurInterface.applyGaussianBlur(image, amount);
    }
    public void setParameterValue(float parameterValue) throws IllegalParameterException{
        if(parameterValue != (float)parameterValue)
            throw new IllegalParameterException();
        amount = parameterValue;
    }
}
