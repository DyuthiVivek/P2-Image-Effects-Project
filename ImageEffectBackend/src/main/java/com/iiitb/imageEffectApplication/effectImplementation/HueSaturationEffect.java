package com.iiitb.imageEffectApplication.effectImplementation;
import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

import com.iiitb.imageEffectApplication.libraryInterfaces.HueSaturationInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class HueSaturationEffect implements ParameterizableEffect{
    private float HueOffset;
    private float SaturationOffset;
    
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        //adding the effect info to the logs
        loggingService.addLog(fileName, "HueSaturation", "Hue offset: " + Float.toString(HueOffset) + " Saturation offset: " + Float.toString(SaturationOffset));
        return HueSaturationInterface.applyHueSaturation(image, HueOffset, SaturationOffset);
    }


    public void setParameter(String paramName1, float value1) throws IllegalParameterException{
        if(paramName1.equals("hueOffset")){
            if(value1 != (float)value1 || value1 < 0.0f || value1 > 100.0f)
                throw new IllegalParameterException();
            HueOffset = value1;
        }
        else if (paramName1.equals("saturationOffset")){
            if(value1 != (float)value1 || value1 < 0.0f || value1 > 100.0f)
                throw new IllegalParameterException();
            SaturationOffset = value1;
        }
        else{
            throw new IllegalParameterException();
        }
    }
    
}