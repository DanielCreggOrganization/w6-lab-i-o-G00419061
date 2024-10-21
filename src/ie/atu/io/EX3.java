package ie.atu.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EX3 {
    public static void main(String[] args) {
        String filePath = "resources/input.txt";
        FileInputStream fis = null;

        try{
            fis = new FileInputStream(filePath);
            int data;
            while ((data = fis.read())!=-1) {
                System.out.println((char) data);
                
            }
        }catch (IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }finally{
            try{
                if (fis !=null){
                    fis.close();
                }
            }catch(IOException e){
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
