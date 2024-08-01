package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Client;
import za.ac.cput.factory.ClientFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ClientServiceTest {

    @Autowired
    ClientService clientService;
    private static Client client1;
    private static Client client2;

    @Test
    void a_setup(){
        client1=new ClientFactory().buildClient("larjanus@gmail.com","larjanus123","freepalestine","0821238976","Lar","Janus");
        assertNotNull(client1);
        client2=new ClientFactory().buildClient("hughjanus@gmail.com","hughjanus123","freepalestine","069876969","Hugh","Janus");
        assertNotNull(client2);
    }
    @Test
    void b_create() {
        Client created1=clientService.create(client1);
        assertNotNull(created1);
        System.out.println(created1);
        Client created2=clientService.create(client2);
        assertNotNull(created2);
        System.out.println(client2);
    }

    @Test
    void c_read() {
        Client read=clientService.read(client1.getEmail());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Client newCLient=new Client.Builder().copy(client1).setUsername("theWolverine").build();
        Client updatedCLient=clientService.update(newCLient);
        assertNotNull(updatedCLient);
        System.out.println(updatedCLient);
    }

    @Test
    void e_getAll() {
        System.out.println(clientService.getAll());
    }

    @Test
    @Disabled
    void f_delete() {
        clientService.delete(client2.getEmail());
        System.out.println("Client successfully deleted!");
    }
}