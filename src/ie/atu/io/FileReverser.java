package ie.atu.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReverser {
    public static void main(String[] args) {
        try (
                FileReader reader = new FileReader("resources/input.txt");
                FileWriter writer = new FileWriter("resources/output.txt");
                FileWriter writer2 = new FileWriter("resources/output2.txt")) {

            int character;
            int charCount = 0;
            while ((character = reader.read()) != -1) {
                writer.write(Character.toUpperCase(character));
                writer2.write(charCount);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
