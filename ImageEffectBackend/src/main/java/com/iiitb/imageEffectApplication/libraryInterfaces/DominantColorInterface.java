package com.iiitb.imageEffectApplication.libraryInterfaces;

public class DominantColorInterface {
    static {
        String libraryPath = "DominantColorLib";
        LoadNativeLibrary.loadNativeLibrary(libraryPath);
    }
    public static native Pixel[][] applyDominantColor(Pixel[][] image);
}