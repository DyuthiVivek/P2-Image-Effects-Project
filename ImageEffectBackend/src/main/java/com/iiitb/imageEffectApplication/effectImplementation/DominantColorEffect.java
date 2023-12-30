package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.DominantColorInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class DominantColorEffect implements SingleValueDiscreteEffect {
    private int toApply = 0;

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "Dominant Color", "");
        return DominantColorInterface.applyDominantColorPixels(image);
    }

    public void setParameterValue(int value) throws IllegalParameterException {
        toApply = value;
    }
}
