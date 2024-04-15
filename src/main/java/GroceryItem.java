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
}
