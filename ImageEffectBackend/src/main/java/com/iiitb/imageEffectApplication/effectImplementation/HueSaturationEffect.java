package main.java.com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.libraryInterfaces.HueSaturationInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class HueSaturationEffect implements ParameterizableEffect{
    private float HueOffset;
    private float SaturationOffset;
    
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "HueSaturation", Float.toString(HueOffset, SaturationOffset));
        return HueSaturationInterface.applyHueSaturation(image, HueOffset, SaturationOffset);
    }

    public void setParameter(String paramName1, String paramName2, float value1, float value2) throws IllegalParameterException{
        if(value1 != (float)value1)
            throw new IllegalParameterException();
        HueOffset = value1;
        if(value2 != (float)value2)
            throw new IllegalParameterException();
        SaturationOffset = value2;
    }

    
}