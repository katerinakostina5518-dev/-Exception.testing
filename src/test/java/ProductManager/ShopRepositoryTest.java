package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldRemoveExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Книга", 100);
        Product product2 = new Product(2, "Ручка", 50);
        Product product3 = new Product(3, "Тетрадь", 200);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(2);
        Product[] expected = { product1, product3 };
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundExceptionForNonExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Книга", 100);
        Product product2 = new Product(2, "Ручка", 50);

        repo.add(product1);
        repo.add(product2);

        Assertions.assertThrows(NotFoundException.class,() -> repo.removeById(3));

    }

}
