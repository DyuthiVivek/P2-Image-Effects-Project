package com.iiitb.imageEffectApplication.service;
import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.*;

@Service
public class LoggingService {

    public void addLog(String fileName, String effectName, String optionValues) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        LogModel logModel = new LogModel(timeStamp, fileName, effectName, optionValues);
        File file = new File("/home/dyuthi/prog2/P2-Image-Effects-Project/ImageEffectBackend/src/main/java/com/iiitb/imageEffectApplication/service/logs");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(logModel);
            System.out.println("I wrote something");
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
        catch(Exception e){
            e.printStackTrace();
        }        
        return listOfLogs;
    }

    public List<LogModel> getLogsByEffect(String effectName) {
        return new ArrayList<LogModel>();
    }

    public void clearLogs() {
        return;
    }

    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime) {
        return new ArrayList<LogModel>();
    }
}
