import org.apache.commons.io.IOUtils;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    public String replacingSemi(String input){
        return input.replaceAll("[!@;^%*]",",");
    }
    public String wrapInJson(String input) {
        StringBuilder sb = new StringBuilder();
        String[] pairs = input.split(",");
        for (int i = 0; i < pairs.length; i++) {
            String[] keyValue = pairs[i].split(":");
            if (keyValue.length >= 2) {
                sb.append("\"").append(keyValue[0]).append("\":\"").append(keyValue[1]).append("\"");
                if (i < pairs.length - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }
    public String replaceDoublePound(String input){
        String[] pairs = input.split("##");
        return Arrays.toString(pairs);
    }
    public String toLowercase(String input){
        return input.toLowerCase();
    }
    public static String addNewline(String input) {
        String regex = "(\\d{4}),";
        String replacement = "$1,\n";
        return input.replaceAll(regex, replacement);
    }

    public String jsonFormat(String input){
        String replaced = replacingSemi(input);
        String split = replaceDoublePound(replaced);
        String lowercase = toLowercase(split);
        return addNewline(lowercase);

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
