package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Client;
import za.ac.cput.factory.ClientFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientFactoryTest {

    @Test
    @Order(1)
    void buildClient(){
        //Build Client
        Client client=new ClientFactory().buildClient("larjanus@gmail.com","larjanus123","freepalestine","08213","Lar","Janus");
        assertNotNull(client);
        System.out.println(client);
    }
    @Test
    @Order(2)
    void testWithFail(){
        //Fail Test with incorrect email format
        Client client=new ClientFactory().buildClient("larjanus","larjanus123","freepalestine","08213","Lar","Janus");
        assertNotNull(client);
        System.out.println(client);
    }

}