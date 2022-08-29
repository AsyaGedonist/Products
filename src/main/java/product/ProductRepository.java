package product;

public class ProductRepository {

    public Product[] products = new Product[0];

    public ProductRepository() {
    }

    public void save(Product product) {
        int haveId = 0;
        for (Product prod : products) {
            if (product.getId() != prod.getId()) {
                continue;
            } else {
                haveId++;
            }
        }

        if (haveId == 0) {
            Product[] tmp = new Product[products.length + 1];
            for (int i = 0; i < products.length; i++) {
                tmp[i] = products[i];
            }
            tmp[tmp.length - 1] = product;
            products = tmp;
        } else {
            throw new AlreadyExistsException(
                    "Element with id: " + product.getId() + " is already exist");
        }
    }


    public Product[] getItems() {
        return products;
    }

    public Product[] removeById(int id) {
        Product pr = null;
        for (Product product : products) {
            if (product.getId() == id) {
                pr = product;
            }
        }
        if (pr == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found");
        } else {

            Product[] tmp = new Product[products.length - 1];
            int copyToIndex = 0;
            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[copyToIndex] = product;
                    copyToIndex++;
                }
            }
            products = tmp;
            return products;
        }
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
