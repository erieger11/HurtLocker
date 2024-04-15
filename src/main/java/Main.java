import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Main {
    public ArrayList<String> splitEachItem = new ArrayList<>();
    public ArrayList<String> readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return jsonFormat(result);
    }

    public static void main(String[] args) throws Exception{
        ArrayList<String> output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
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
    public ArrayList<String> eachItem(String input) {
        String[] items = input.split(";");
        for (String item : items) {
            splitEachItem.add(item.trim());
        }
        splitEachItem.replaceAll(s -> s
                .replaceAll("name:", "")
                .replaceAll("price:", "")
                .replaceAll("type:", "")
                .replaceAll("expiration:", ""));
        return splitEachItem;
    }
    public ArrayList<String> entireList(ArrayList<String> input){
         HashMap<String,GroceryItem> everyItemOnTheList = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            //GroceryItem groceryItem = new GroceryItem(input.get(i).substring(input.indexOf(:+1))   , );
//my goal was to imput the string into the constructor but I can't figure it out
        }
        return null;
    }


    public ArrayList<String> jsonFormat(String input){
        String replaced = replacingSpecial(input);
        String split = replaceDoublePound(replaced);
        String lowercase = toLowercase(split);
        String newLine = addNewline(lowercase);
        String nullValues = addNull(newLine);
        return eachItem(nullValues);
    }




}
