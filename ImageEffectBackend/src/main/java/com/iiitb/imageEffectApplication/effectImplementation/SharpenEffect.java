package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.SharpenInterface;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class SharpenEffect implements ParameterizableEffect{
    private float sharpenAmount;
    
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        return SharpenInterface.applySharpen(image, 0);
    }

    public void setParameter(String paramName, float value){
        sharpenAmount = value;
    }
}
