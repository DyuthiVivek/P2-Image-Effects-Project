package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.GaussianBlurInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class GaussianBlurEffect implements SingleValueParameterizableEffect{
    private float amount;
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "GaussianBlur", Float.toString(amount));    //adding logging
        return GaussianBlurInterface.applyGaussianBlur(image, amount);
    }
    public void setParameterValue(float parameterValue) throws IllegalParameterException{   //setting parameter and throwing exception if value out of range
        if(parameterValue != (float)parameterValue || parameterValue<0.0f || parameterValue>50.0f)
            throw new IllegalParameterException();
        amount = parameterValue;
    }
}
