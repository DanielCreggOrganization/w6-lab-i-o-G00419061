package ie.atu.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EX6 {
    public static void main(String[] args) {
        String inputPath = "resources/input.txt";
        String outputPath = "resources/output.txt";
        int wordCount = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for(int i = 0; i < words.length; i++){
                    wordCount++;
                    if(i % 2 == 0){
                        writer.write(words[i].toUpperCase() + " ");
                    }else{
                        writer.write(words[i] + " ");
                    }
                    writer.newLine();
                    if(wordCount % 100 == 0){
                        System.out.println(".");
                    }
                }
            }
            System.out.println("File processed with buffered I/O.");
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
