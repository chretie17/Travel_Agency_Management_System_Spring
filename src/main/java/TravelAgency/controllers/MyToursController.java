package TravelAgency.controllers;

import TravelAgency.entities.User;
import TravelAgency.services.UserService;
import TravelAgency.services.OrderService;
import TravelAgency.utils.MyTours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/myTours")
public class MyToursController {
    private MyTours cart;
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public void setCart(MyTours cart) {
        this.cart = cart;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showCart(Model model) {
        model.addAttribute("items", cart.getItems());
        return "myTours";
    }

    @GetMapping("/add/{id}")
    public String addProductToCart(Model model, @PathVariable("id") Long id) {
        cart.addProductById(id);
        return "redirect:/myTours";
    }

    @GetMapping("/create_order")
    public String createOrder(Principal principal, RedirectAttributes redirectAttributes) {
        try {
            if (principal == null) {
                throw new RuntimeException("User not authenticated");
            }

            User user = userService.findByUsername(principal.getName())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            orderService.createOrderFromItems(user, cart.getItems());
            cart.getItems().clear();

            return "redirect:/tours";
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            redirectAttributes.addFlashAttribute("error", "An error occurred while processing your order.");
            return "redirect:/myTours";
        }
    }
}

