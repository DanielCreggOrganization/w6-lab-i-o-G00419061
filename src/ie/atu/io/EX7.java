package ie.atu.io;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EX7 {
    public static void main(String[] args) {
        String inputPath = "resources/input.txt";

        // Reading and counting words
        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            long wordCount = lines.flatMap(line -> Arrays.stream(line.split("\\s+")))
                                .count();
            System.out.println("Number of words: " + wordCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Counting lines that contain a specific word
        /*String specificWord = "Java";
        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            lines.forEach(line -> System.out.println("Line: " + line));
        } catch (IOException e) {
            long count = lines.filter(line -> line.contains(specificWord)).count();
            System.err.println("Error processing file: " + e.getMessage());
        }*/

       //Word Frequency counter
       try(Stream<String> lines = Files.lines(Paths.get(inputPath))){
        Map<String, Long> wordFreq = lines.flatMap(line -> Arrays.stream(line.split("\\s+"))).collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        wordFreq.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(5).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
       }catch(IOException e){
        System.err.println("Error reading file: " + e.getMessage());;
       }

       //Processing all text files in the resources directory
       try(Stream<Path> paths = Files.list(Paths.get("resources"))){
        paths.filter(filter::isRegularFile).filter(path->path.toString().endsWith(".txt")).forEach(path ->{
            try(Stream<String> lines = Files.lines(path)){
                long lineCount = lines.count();
            }catch(IOException e){
                System.err.println("Error reading file: " + e.getMessage());
            }
        });
       }catch(IOException e){
            System.err.println("Error listing files: " + e.getMessage());
       }
    }
}
