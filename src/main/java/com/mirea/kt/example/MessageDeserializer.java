package com.mirea.kt.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class MessageDeserializer {
    private String filePath;
    
    //Необходимо создать переменную со специальным названием, которую необходимо приравнять к -3380157693869190848L (тип long)
private static final long serialVersionUID = -3380157693869190848L;
    
    public MessageDeserializer(String filePath) {
        this.filePath = filePath;
    }

    public void startDeserialization() {
        Thread deserializationThread = new Thread(this::deserializeMessage); 
        deserializationThread.start();
    }

    private void deserializeMessage() {
        
        try (FileInputStream fileIn = new FileInputStream(filePath); 
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) { 

            Message message = (Message) objectIn.readObject(); 
            printMessageDetails(message); 

        } catch (FileNotFoundException e) { 
            System.err.println("Файл не найден: " + filePath);
        } catch (IOException | ClassNotFoundException e) { 
            e.printStackTrace();
        }
    }

    private void printMessageDetails(Message message) {
        System.out.println("ID: " + message.getId());
        System.out.println("Body: " + message.getBody());
        System.out.println("Type: " + message.getType());
        System.out.println("Has Attachments: " + message.isHasAttachments());
        System.out.println("Timestamp: " + message.getTimestamp());
    }
}

