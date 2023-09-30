package ua.goit.module10.Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;

public class TextToJson {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\Zhenia\\Documents\\GoIT\\Module10\\src\\main\\java\\ua\\goit\\module10\\Task2\\file.txt";
        String outputFilePath = "C:\\Users\\Zhenia\\Documents\\GoIT\\Module10\\src\\main\\java\\ua\\goit\\module10\\Task2\\user.json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            String line;
            List<Map<String, String>> userList = new ArrayList<>();
            String[] headers = null;

            if ((line = reader.readLine()) != null) {
                headers = line.split(" ");
            }

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == headers.length) {
                    Map<String, String> userMap = new HashMap<>();
                    for (int i = 0; i < headers.length; i++) {
                        userMap.put(headers[i], parts[i]);
                    }
                    userList.add(userMap);
                }
            }
            reader.close();

            FileWriter writer = new FileWriter(outputFilePath);
            gson.toJson(userList, writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

