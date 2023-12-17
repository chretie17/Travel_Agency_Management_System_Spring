package TravelAgency.controllers;

import TravelAgency.entities.User;
import TravelAgency.entities.UserDTO;
import TravelAgency.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String getUserProfile(Model model) {
        // Replace the mock method with the actual logic to get the authenticated user
        User authenticatedUser = getAuthenticatedUser();

        if (authenticatedUser != null) {
            // Convert User entity to UserDTO
            UserDTO userDTO = new UserDTO(authenticatedUser.getUsername(), authenticatedUser.getEmail());
            model.addAttribute("userDTO", userDTO);
            // Change this line in showUserProfile method
            return "/profile";
        } else {
            // Handle the case where the user is not authenticated
            // You can redirect to the login page or return an error response
            return "redirect:/login"; // Redirect to the login page
        }
    }

    // Replace this mock method with the actual logic to get the authenticated user
    private User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof User) {
                return (User) principal;
            }
        }

        return null;
    }

    // Display a list of all users
    @GetMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "/list";
    }

    // Display the form for adding a new user
    @GetMapping("/add")
    public String showAddForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/add";
    }

    // Process the form submission for adding a new user
    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        // Change these lines in addUser and updateUser methods
        return "redirect:/list";

    }

    // Display the form for updating a user
    // Change this line in showUpdateForm method
    @GetMapping("/update/{username}")
    public String showUpdateForm(@PathVariable(name = "username") String username, Model model) {
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user username: " + username));

        model.addAttribute("user", user);
        return "update";
    }

    // Process the form submission for updating a user
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        // Change these lines in addUser and updateUser methods
        return "redirect:/admin";

    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username, RedirectAttributes redirectAttributes) {
        userService.deleteUser(username);

        // Add a flash attribute for success message
        redirectAttributes.addFlashAttribute("successMessage", "User deleted successfully");

        // Redirect to the same page or any other page you want
        return "redirect:/admin";
    }

}
