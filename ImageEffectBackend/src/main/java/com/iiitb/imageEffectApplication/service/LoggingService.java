package com.iiitb.imageEffectApplication.service;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iiitb.imageEffectApplication.model.LogModel;

@Service
public class LoggingService {

    public void addLog(String fileName, String effectName, String optionValues) {

        // create new timestamp
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(new java.util.Date());

        // create an object of LogModel class
        LogModel logModel = new LogModel(timeStamp, fileName, effectName, optionValues);

        // get all logs, writing again to logs file
        List <LogModel> listOfLogs = getAllLogs();

        // add absolute file path here
        File file = new File("/home/dyuthi/prog2/P2-Image-Effects-Project/ImageEffectBackend/src/main/java/com/iiitb/imageEffectApplication/service/logs");
        
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // writing all LogModel objects
            for(LogModel log: listOfLogs)
                oos.writeObject(log);

            // writing the new LogModel object
            oos.writeObject(logModel);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public List<LogModel> getAllLogs() {

        // reading all LogModel objects from the logs binary file
        ArrayList <LogModel> listOfLogs = new ArrayList<>();

        // add absolute file path here
        File file = new File("/home/dyuthi/prog2/P2-Image-Effects-Project/ImageEffectBackend/src/main/java/com/iiitb/imageEffectApplication/service/logs");

        try {
            FileInputStream fstream = new FileInputStream(file);
            ObjectInputStream ostream = new ObjectInputStream(fstream);
            while (true) {
                Object obj;
                try {
                    // reading object till end of file reached
                    obj = ostream.readObject();
                } catch (EOFException e) {
                    break;
                }

                // adding to the list of LogModels
                listOfLogs.add((LogModel)obj);
            }
            ostream.close();
            fstream.close();
        }

        // end of file reached
        catch(EOFException e){
            
        }

        // handling other exceptions
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }        
        return listOfLogs;
    }

    public List<LogModel> getLogsByEffect(String effectName) {

        // getting all logs
        List <LogModel> listOfLogs = getAllLogs();
        ArrayList <LogModel> newList = new ArrayList<>();
        for(LogModel log: listOfLogs){

            // getting the logs with a specific name
            if(log.getEffectName().equals(effectName)){
                newList.add(log);
            }
        }

        // returning new list with logs of the given effect
        return newList;
    }

    public void clearLogs() {

        // clearing contents of the file

        // add absolute file path here
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
        try{

            // getting all logs
            List <LogModel>listOfLogs = getAllLogs();
            ArrayList <LogModel> newList = new ArrayList<>();
            for(LogModel log: listOfLogs){

                // converting the timestamp from the log to LocalDateTime format
                DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .parseCaseInsensitive()
                    .appendPattern("yyyy-MM-dd hh:mm:ss a")
                    .toFormatter();
                LocalDateTime dateTime = LocalDateTime.parse(log.getTimestamp(), formatter);

                // checking if it is within the start and end time
                if (dateTime.isAfter(startTime) && dateTime.isBefore(endTime)) {

                    // adding it to the list
                    newList.add(log);
                }

            }
            return newList;
        }
        catch (DateTimeException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
