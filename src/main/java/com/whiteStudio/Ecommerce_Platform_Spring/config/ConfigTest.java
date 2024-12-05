package com.whiteStudio.Ecommerce_Platform_Spring.config;

import com.whiteStudio.Ecommerce_Platform_Spring.entities.*;
import com.whiteStudio.Ecommerce_Platform_Spring.entities.enums.OrderStatus;
import com.whiteStudio.Ecommerce_Platform_Spring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class ConfigTest implements CommandLineRunner {
    @Autowired
    private UserRepository _repUs;

    @Autowired
    private OrderRepository _repOr;

    @Autowired
    private CategoryRepository _repCa;

    @Autowired
    private ProductRepository _repPr;

    @Autowired
    private OrderItemRepository _repOi;

    @Override
    public void run(String... args) throws Exception {

        // cat, product

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        _repCa.saveAll(Arrays.asList(cat1, cat2, cat3));

        p2.addCategory(cat1);
        p1.addCategory(cat2);
        p5.addCategory(cat2);
        p3.addCategory(cat3);
        p4.addCategory(cat3);
        p2.addCategory(cat3);

        _repPr.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        // Order, user

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        _repUs.saveAll(Arrays.asList(u1,u2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);

        _repOr.saveAll(Arrays.asList(o1,o2,o3));

        OrderItem oi1 = new OrderItem(o1, p1, p1.getPrice(),2);
        OrderItem oi2 = new OrderItem(o1, p3, p3.getPrice(),1);
        OrderItem oi3 = new OrderItem(o2, p3, p3.getPrice(),2);
        OrderItem oi4 = new OrderItem(o3, p5, p5.getPrice(),2);

        _repOi.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

        // o pagamento ( payment ) é dependente do pedido ( order ), portanto, não precisa de um repositório próprio, apenas precisa de um pedido pra "fazer parte"

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);

        // portanto, pra salvar esse pagamento, basta o adicionar ao pedido que colocamos no constructor

        o1.setPayment(pay1);

        _repOr.save(o1);
    }
}
