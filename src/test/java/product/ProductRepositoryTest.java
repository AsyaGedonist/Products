package product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductRepositoryTest {
    Product product1 = new Product(1, "1", 10);
    Product product2 = new Product(2, "2", 20);
    Product product3 = new Product(3, "3", 30);
    Product product4 = new Product(4, "4", 40);

    @Test
    public void shouldDel() {

        ProductRepository products = new ProductRepository();

        Product[] expected = {product1, product2, product4};

        products.save(product1);
        products.save(product2);
        products.save(product3);
        products.save(product4);
        products.removeById(3);
        Product [] actual = products.getItems();

        Assertions.assertEquals(expected, actual);
    }
}
