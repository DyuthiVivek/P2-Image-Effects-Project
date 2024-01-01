package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.ContrastInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class ContrastEffect implements SingleValueParameterizableEffect{
    private float constrastAmount;

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){        //adding logging
        loggingService.addLog(fileName, "Contrast", Float.toString(constrastAmount));
        return ContrastInterface.applyContrast(image, constrastAmount);
    }

    public void setParameterValue(float parameterValue) throws IllegalParameterException{     //setting parameter and throwing exception if value out of range
        if(parameterValue != (float)parameterValue || parameterValue<0.0f || parameterValue >200.0f)
            throw new IllegalParameterException();
        constrastAmount = parameterValue;
    }

}
