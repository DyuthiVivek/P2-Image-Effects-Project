package com.iiitb.imageEffectApplication.service;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iiitb.imageEffectApplication.model.LogModel;

@Service
public class LoggingService {

    public void addLog(String fileName, String effectName, String optionValues) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
        System.out.println(timeStamp);
        LogModel logModel = new LogModel(timeStamp, fileName, effectName, optionValues);
        List <LogModel> listOfLogs = getAllLogs();
        File file = new File("/home/dyuthi/prog2/P2-Image-Effects-Project/ImageEffectBackend/src/main/java/com/iiitb/imageEffectApplication/service/logs");
        
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(LogModel log: listOfLogs)
                oos.writeObject(log);
            oos.writeObject(logModel);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public List<LogModel> getAllLogs() {
        ArrayList <LogModel> listOfLogs = new ArrayList<>();
        File file = new File("/home/dyuthi/prog2/P2-Image-Effects-Project/ImageEffectBackend/src/main/java/com/iiitb/imageEffectApplication/service/logs");

        try {
            FileInputStream fstream = new FileInputStream(file);
            ObjectInputStream ostream = new ObjectInputStream(fstream);
            while (true) {
                Object obj;
                try {
                    obj = ostream.readObject();
                } catch (EOFException e) {
                    break;
                }
                listOfLogs.add((LogModel)obj);
            }
            ostream.close();
            fstream.close();
        }
        catch(EOFException e){
            
        }

        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }        
        return listOfLogs;
    }

    public List<LogModel> getLogsByEffect(String effectName) {
        ArrayList <LogModel> listOfLogs = new ArrayList<>();
        File file = new File("/home/dyuthi/prog2/P2-Image-Effects-Project/ImageEffectBackend/src/main/java/com/iiitb/imageEffectApplication/service/logs");

        try {
            FileInputStream fstream = new FileInputStream(file);
            ObjectInputStream ostream = new ObjectInputStream(fstream);
            while (true) {
                Object obj;
                try {
                    obj = ostream.readObject();
                } catch (EOFException e) {
                    break;
                }

                if(((LogModel)obj).getEffectName().equals(effectName))
                    listOfLogs.add((LogModel)obj);
            }
            ostream.close();
            fstream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }        
        return listOfLogs;

    }

    public void clearLogs() {
        File file = new File("/home/dyuthi/prog2/P2-Image-Effects-Project/ImageEffectBackend/src/main/java/com/iiitb/imageEffectApplication/service/logs");
        try{
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return;
    }

    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime) {
        System.out.println(startTime);
        return new ArrayList<LogModel>();
    }
}
