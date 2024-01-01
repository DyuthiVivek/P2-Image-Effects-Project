package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.libraryInterfaces.DominantColorInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class DominantColorEffect implements PhotoEffect {

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "Dominant Color", "");  //adding logging
        return DominantColorInterface.applyDominantColor(image);
    }


}
