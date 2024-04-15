import org.junit.Assert;
import org.junit.Test;

public class GroceryItemTest {
    @Test
    public void GroceryItemConstructorTest() {
        String name = "Carrots";
        Double price = 2.58;
        String type = "Food";
        String expiration = "1/23/24";

        GroceryItem carrots = new GroceryItem(name,price,type,expiration);

        String retrievedName = carrots.getName();
        Double retrievedPrice = carrots.getPrice();
        String retrievedType = carrots.getType();
        String retrievedExpiration = carrots.getExpiration();

        Assert.assertEquals(name, retrievedName);
        Assert.assertEquals(type, retrievedType);
        Assert.assertEquals(price, retrievedPrice);
        Assert.assertEquals(expiration, retrievedExpiration);

    }
    @Test
    public void replacingSemiTest() {
        String s1 = "Milk;Bread;Cookies";
        String s2 = "Milk,Bread,Cookies";

        GroceryItem list = new GroceryItem(null,null,null,null);
        String actual = list.replacingSemi(s1);

        Assert.assertEquals(s2, actual);
    }
    @Test
    public void addingQuotesTest() {
        String s1 = "apples:1.23,cookies:1.39";;
        String s2 = "\"apples\":\"1.23\",\"cookies\":\"1.39\"";

        GroceryItem list = new GroceryItem(null,null,null,null);
        String actual = list.wrapInJson(s1);

        Assert.assertEquals(s2, actual);
    }
    @Test
    public void jsonTest(){
        String s1 = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String s2 = "\"naMe\":\"Milk\",\"price\":\"3.23\",\"type\":\"Food\",\"expiration\":\"1/25/2016\"";

        GroceryItem list = new GroceryItem(null,null,null,null);

        String actual = list.jsonFormat(s1);

        Assert.assertEquals(s2, actual);
    }

}