import org.apache.commons.io.IOUtils;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {

    public String replacingSpecial(String input) {
        return input.replaceAll("[!@;^%*]", ",");
    }
    public String replaceDoublePound(String input){
        String[] pairs = input.split("##");
        return Arrays.toString(pairs);
    }
    public String toLowercase(String input){
        return input.toLowerCase();
    }
    public String addNewline(String input) {
        String regex = "(\\d{4}),";
        String replacement = "$1,\n";
        return input.replaceAll(regex, replacement);
    }


    public String addNull(String input) {
        StringBuilder sb = new StringBuilder();
        char[] word = input.toCharArray();
        for (int i = 0; i < word.length - 1; i++) {
            if (word[i] == ':' && word[i + 1] == ',') {
                sb.append(":NULL,");
                i++;
            } else {
                sb.append(word[i]);
            }
        }
        if (word[word.length - 1] != ',') {
            sb.append(word[word.length - 1]);
        }
        return sb.toString();
    }
    public String jsonFormat(String input){
        String replaced = replacingSpecial(input);
        String split = replaceDoublePound(replaced);
        String lowercase = toLowercase(split);
        String newLine = addNewline(lowercase);
        return addNull(newLine);

    }
    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return jsonFormat(result);
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }

}
