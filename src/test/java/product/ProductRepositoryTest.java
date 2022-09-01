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
        Product[] actual = products.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotDel() {

        ProductRepository products = new ProductRepository();

        products.save(product1);
        products.save(product2);
        products.save(product3);
        products.save(product4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            products.removeById(5);
        });
    }

    @Test
    public void shouldAdd() {

        ProductRepository products = new ProductRepository();

        Product[] expected = {product1};

        products.save(product1);

        Product[] actual = products.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotAdd() {

        ProductRepository products = new ProductRepository();

        products.save(product1);
        products.save(product2);
        products.save(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            products.save(product2);
        });
    }

    @Test
    public void shouldFind(){

        ProductRepository products = new ProductRepository();

        products.save(product1);
        products.save(product2);
        products.save(product3);

        Product[] expected = {product2};
        Product[] actual = products.findById(2);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFind(){

        ProductRepository products = new ProductRepository();

        products.save(product1);
        products.save(product2);
        products.save(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            products.findById(5);
        });
    }
}