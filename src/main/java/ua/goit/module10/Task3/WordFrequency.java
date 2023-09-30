package ua.goit.module10.Task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\Users\\Zhenia\\Documents\\GoIT\\Module10\\src\\main\\java\\ua\\goit\\module10\\Task3\\words.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            for (String word : line) {
                if (wordFrequencyMap.containsKey(word)) {
                    wordFrequencyMap.put(word, wordFrequencyMap.get(word) + 1);
                } else {
                    wordFrequencyMap.put(word, 1);
                }
            }
        }
        scanner.close();

        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }
}

