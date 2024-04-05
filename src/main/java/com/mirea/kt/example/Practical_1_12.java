package com.mirea.kt.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practical_1_12 {

    public static void main(String[] args) {
        System.out.println ("Козлова Динара Артёмовна, РИБО-01-22, Вариант 2, ");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу для десериализации:");
       
        try {
            String filePath = reader.readLine(); 
            MessageDeserializer deserializer = new MessageDeserializer(filePath); 
            deserializer.startDeserialization(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
