package TravelAgency.services;

import TravelAgency.entities.Order;
import TravelAgency.entities.OrderItem;
import TravelAgency.entities.User;
import TravelAgency.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// OrderService.java
@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrderFromItems(User user, List<OrderItem> items) {
        Order order = new Order();
        order.setItems(new ArrayList<>());
        order.setUser(user);
        items.forEach(item -> {
            order.getItems().add(item);
            item.setOrder(order);
        });
        items.clear();
        return orderRepository.save(order);
    }
}
