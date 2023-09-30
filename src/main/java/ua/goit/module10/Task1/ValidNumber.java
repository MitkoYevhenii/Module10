package ua.goit.module10.Task1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ValidNumber {
    private static final String PHONE_NUMBER_REGEX = "^\\(\\d{3}\\)\\s\\d{3}-\\d{4}|^\\d{3}-\\d{3}-\\d{4}";

    public static void validNumber(String path) {
        File file = new File(path);
        //List<Character> fileCharList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        try (FileReader reader = new FileReader(file)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                if ((char) ch == '\r') {
                    printValidNumber(stringBuilder.toString());
                    stringBuilder.setLength(0);
                    continue;
                } else if ((char) ch == '\n') {
                    continue;
                }
                stringBuilder.append((char) ch);
            }
            printValidNumber(stringBuilder.toString());
            stringBuilder.setLength(0);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static String listToString(List<Character> charList) {
        StringBuilder stringBuilder = new StringBuilder(charList.size());

        for (Character c : charList) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void printValidNumber(String number) {
        if (number.matches(PHONE_NUMBER_REGEX)) {
            System.out.println(number);
        }
    }

    public static boolean isValidNumber(String number) {
        return number.matches(PHONE_NUMBER_REGEX);
    }
}


class ValidNumberTest {
    public static final String PATH = "C:\\Users\\Zhenia\\Documents\\GoIT\\Module10\\src\\main\\java\\ua\\goit\\module10\\Task1\\file.txt";
    public static void main(String[] args) {

        ValidNumber.validNumber(PATH);
    }
}
