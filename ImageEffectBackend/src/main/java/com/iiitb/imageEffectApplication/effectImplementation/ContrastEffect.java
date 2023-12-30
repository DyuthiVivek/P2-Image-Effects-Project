package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.ContrastInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class ContrastEffect implements SingleValueParameterizableEffect{
    private float constrastAmount;

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "Contrast", Float.toString(constrastAmount));
        return ContrastInterface.applyContrast(image, constrastAmount);
    }

    public void setParameterValue(float parameterValue) throws IllegalParameterException{
        if(parameterValue != (float)parameterValue)
            throw new IllegalParameterException();
        constrastAmount = parameterValue;
        System.out.println(constrastAmount+"lalalla");
    }

}
