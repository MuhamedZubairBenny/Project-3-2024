package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductFactoryTest {

    @Test
    @Order(1)
    void buildProduct() {
        //Build Product
        Product product = new ProductFactory().buildProduct("1234", "Hair Gel", " Hair gel for styling gents hair", 50.99,2);
        assertNotNull(product);
        System.out.println(product);
    }

    @Test
    @Order(2)
    void buildProductWithNoProductId() {
        // Build Product without id
        Product product = new ProductFactory().buildProduct("Beard oil","Oil for beard",29.99,5);
        assertNotNull(product);
        System.out.println(product);
    }
    @Test
    @Order(3)
    void buildWithFail(){
        Product product = new ProductFactory().buildProduct("","Hair comb","Comb for hair",25.00,7);
        assertNotNull(product);
        System.out.println(product);
    }
}