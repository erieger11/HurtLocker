import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

public class GroceryItem {
    private String name;
    private String type;
    private Double price;
    private String expiration;


    public GroceryItem(String name, Double price, String type, String expiration) {
        this.name=name;
        this.type=type;
        this.price=price;
        this.expiration=expiration;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public Double getPrice(){
        return price;
    }
    public String getExpiration(){
        return expiration;
    }


    public String replacingSemi(String input){
        return input.replaceAll(";",",");
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

    public String jsonFormat(String input){
        String replaced = replacingSemi(input);
        String split = replaceDoublePound(replaced);
        return wrapInJson(split);

    }



}
