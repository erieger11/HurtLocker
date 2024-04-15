import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MainTest {

    Main main = new Main();

    @Test
    public void replaceSpecialTest() {
        String s1 = "Milk;Bread@Cookies";
        String s2 = "Milk,Bread,Cookies";

        String actual = main.replacingSpecial(s1);

        assertEquals(s2, actual);
    }

    @Test
    public void replaceDoublePoundTest() {
        String s1 = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016";
        String s2 = "[naMe:Milk;price:3.23;type:Food;expiration:1/25/2016, naME:BreaD;price:1.23;type:Food;expiration:1/02/2016]";

        String actual = main.replaceDoublePound(s1);

        assertEquals(s2, actual);
    }

    @Test
    public void toLowercaseTest() {
        String s1 = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016";
        String s2 = "name:milk;price:3.23;type:food;expiration:1/25/2016##name:bread;price:1.23;type:food;expiration:1/02/2016";

        String actual = main.toLowercase(s1);

        assertEquals(s2, actual);
    }

    @Test
    public void addNewLineTest() {
        String s1 = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016,naME:BreaD;price:1.23;type:Food;expiration:1/02/2016";
        String s2 = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016,\nnaME:BreaD;price:1.23;type:Food;expiration:1/02/2016";

        String actual = main.addNewline(s1);

        assertEquals(s2, actual);
    }
//    @Test
//    public void jsonFormatTest() {
//        String s1 = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016,naME:BreaD;price:1.23;type:Food;expiration:1/02/2016";
//        String s2 = "[name:milk,price:3.23,type:food,expiration:1/25/2016,\nname:bread,price:1.23,type:food,expiration:1/02/2016]";
//
//        ArrayList<String> actual = main.jsonFormat(s1);
//
//        assertEquals(s2, actual);
//    }
}
