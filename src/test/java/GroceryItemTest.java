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
}