package TravelAgency.utils;

import TravelAgency.entities.OrderItem;
import TravelAgency.entities.Tours;
import TravelAgency.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyTours {
    private List<OrderItem> items;

    private TourService tourService;

    @Autowired
    public void setTourService(TourService tourService) {
        this.tourService = tourService;
    }

    public List<OrderItem> getItems() {
        if (items == null) {
            init();
        }
        return items;
    }

    public void init() {
        items = new ArrayList<>();
    }

    public void addProductById(Long id) {
        Tours tours = tourService.getProductById(id);
        OrderItem orderItem = new OrderItem();
        orderItem.setTour(tours);  // Update this line
        getItems().add(orderItem);
    }
}
