package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProductServiceTest {
    @Autowired
    private ProductService productService;
    private static Product product1;
    private static Product product2;
    @Test
    void a_setup() {
        product1 = ProductFactory.buildProduct("1234","Scissors","Scissors to trim hair and beard",35.00,5);
        assertNotNull(product1);
        product2 = ProductFactory.buildProduct("2345","Shampoo","Shampoo product to remove all dirt buildup on your hair.",65.00,10);
        assertNotNull(product2);
    }

    @Test
    void b_create() {
        Product created1 = productService.create(product1);
        assertNotNull(created1);
        System.out.println(created1);
        Product created2 = productService.create(product2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        Product read = productService.read(product1.getProductId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Product newPrice = new Product.Builder().copy(product1).setPrice(40.00).build();
        Product updatedPrice = productService.update(newPrice);
        assertNotNull(updatedPrice);
        System.out.println(updatedPrice);
    }

    @Test
    @Disabled
    void e_delete() {
        productService.delete(product2.getProductId());
        System.out.println("Product has been successfully deleted");
    }
@Test
    void f_getAll(){System.out.println(productService.getAll());}
}