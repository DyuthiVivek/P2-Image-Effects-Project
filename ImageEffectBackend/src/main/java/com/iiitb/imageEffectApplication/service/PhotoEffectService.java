package com.iiitb.imageEffectApplication.service;

import com.iiitb.imageEffectApplication.effectImplementation.ContrastEffect;
import com.iiitb.imageEffectApplication.effectImplementation.DominantColorEffect;
import com.iiitb.imageEffectApplication.effectImplementation.FlipEffect;
import com.iiitb.imageEffectApplication.effectImplementation.GaussianBlurEffect;
import com.iiitb.imageEffectApplication.effectImplementation.GrayscaleEffect;
import com.iiitb.imageEffectApplication.effectImplementation.InvertEffect;
import com.iiitb.imageEffectApplication.effectImplementation.SharpenEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.effectImplementation.RotationEffect;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.utils.ProcessingUtils;

import com.iiitb.imageEffectApplication.effectImplementation.HueSaturationEffect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class PhotoEffectService {

    @Autowired
    private ProcessingUtils processingUtils;

    @Autowired
    private LoggingService loggingService;

    public ResponseEntity<byte[]> applyHueSaturationEffect(float hueAmount, float saturationAmount, MultipartFile imageFile) throws IllegalParameterException {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            HueSaturationEffect effect = new HueSaturationEffect();
            effect.setParameter("hueOffset", hueAmount);
            effect.setParameter("saturationOffset", saturationAmount);
            Pixel[][] modifiedImage = effect.apply(inputImage, imageName, loggingService); // Replace this with actual modified image
            // ACTUAL WORK ENDS HERE


            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch(Exception e){
             e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyBrightnessEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();




            // ACTUAL WORK STARTS HERE

            // TODO
            Pixel[][] modifiedImage = inputImage; // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyContrastEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();



            // ACTUAL WORK STARTS HERE

            // TODO
            ContrastEffect effect = new ContrastEffect();
            effect.setParameterValue(amount);
            Pixel[][] modifiedImage = effect.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyFlipEffect(MultipartFile imageFile, int horizontalFlipValue, int verticalFlipValue) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();



            // ACTUAL WORK STARTS HERE

            // TODO
            FlipEffect effect = new FlipEffect();
            effect.selectOptionValue("Horizontal", horizontalFlipValue);
            effect.selectOptionValue("Vertical", verticalFlipValue);
            Pixel[][] modifiedImage = effect.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE




            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    public ResponseEntity<byte[]> applyGaussianBlurEffect(float radius, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            GaussianBlurEffect effect = new GaussianBlurEffect();
            effect.setParameterValue(radius);
            Pixel[][] modifiedImage = effect.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGrayscaleEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            GrayscaleEffect effect = new GrayscaleEffect();
            Pixel[][] modifiedImage = effect.apply(inputImage, imageName, loggingService); // Replace this with actual modified image


            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyInvertEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            InvertEffect effect = new InvertEffect();
            Pixel[][] modifiedImage = effect.apply(inputImage, imageName, loggingService); // Replace this with actual modified image
            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyRotationEffect(int value, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO

            RotationEffect effect = new RotationEffect();
            effect.selectOptionValue("0°", value);
            effect.selectOptionValue("90°", value);
            effect.selectOptionValue("180°", value);
            effect.selectOptionValue("270°", value);
            Pixel[][] modifiedImage = effect.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE


            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
        
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySepiaEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            Pixel[][] modifiedImage = inputImage; // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySharpenEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO

            SharpenEffect effect = new SharpenEffect();
            effect.setParameter(imageName, amount);
            Pixel[][] modifiedImage = effect.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    public ResponseEntity<byte[]> getDominantColour(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            DominantColorEffect effect = new DominantColorEffect();
            effect.setParameterValue(1);
            Pixel[][] modifiedImage = effect.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
