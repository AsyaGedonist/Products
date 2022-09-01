package product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    Product product1 = new Product(1, "1", 10);
    Product product2 = new Book(2, "2", 20, "two", 200, 2002);
    Product product3 = new Book(3, "3", 300_000, "three", 300, 2003);
    Product product4 = new Product(4, "4", 40_000_000);

    @Test
    public void shouldNotBeExpensive(){

    boolean expected = false;
    boolean actual = product1.isTooExpensive();

    Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeExpensive(){

        boolean expected = true;
        boolean actual = product4.isTooExpensive();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void bookShouldNotBeExpensive(){

        boolean expected = false;
        boolean actual = product2.isTooExpensive();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void bookShouldBeExpensive(){

        boolean expected = true;
        boolean actual = product3.isTooExpensive();

        Assertions.assertEquals(expected, actual);
    }

}
