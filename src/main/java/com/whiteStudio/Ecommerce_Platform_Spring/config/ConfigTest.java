package com.whiteStudio.Ecommerce_Platform_Spring.config;

import com.whiteStudio.Ecommerce_Platform_Spring.entities.Category;
import com.whiteStudio.Ecommerce_Platform_Spring.entities.User;
import com.whiteStudio.Ecommerce_Platform_Spring.entities.Order;
import com.whiteStudio.Ecommerce_Platform_Spring.enums.OrderStatus;
import com.whiteStudio.Ecommerce_Platform_Spring.repositories.CategoryRepository;
import com.whiteStudio.Ecommerce_Platform_Spring.repositories.OrderRepository;
import com.whiteStudio.Ecommerce_Platform_Spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
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

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.DELIVERED);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.SHIPPED);

        Category c1 = new Category(null, "Eletronico");
        Category c2 = new Category(null, "Construção");

        _repUs.saveAll(new ArrayList<>(Arrays.asList(u1,u2)));
        _repOr.saveAll(new ArrayList<>(Arrays.asList(o1,o2,o3)));
        _repCa.saveAll(new ArrayList<>(Arrays.asList(c1,c2)));
    }
}
