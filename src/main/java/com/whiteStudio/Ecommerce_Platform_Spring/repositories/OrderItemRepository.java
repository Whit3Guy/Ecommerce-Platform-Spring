package com.whiteStudio.Ecommerce_Platform_Spring.repositories;

import com.whiteStudio.Ecommerce_Platform_Spring.PK.OrderItemPk;
import com.whiteStudio.Ecommerce_Platform_Spring.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}
