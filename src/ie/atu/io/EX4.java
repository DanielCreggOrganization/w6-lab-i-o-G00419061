package ie.atu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EX4 {
    public static void main(String[] args) {
        String inputPath = "resources/input.txt";
        String outputPath = "resources/output.txt";

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            
            int data;
            while((data = fis.read()) != -1){
                fos.write(data);
            }
            System.out.println("File copied successfully.");
        }catch(IOException e){
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}
