package TravelAgency.controllers;

import TravelAgency.entities.User;
import TravelAgency.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);


    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute User user) {
        // Check if the password is not null before encoding
        String rawPassword = user.getPassword();
        if (rawPassword != null) {
            // Set user details, encode password, and save to the database
            user.setPassword(passwordEncoder.encode(rawPassword));
            userService.saveUser(user);
        } else {
            // Handle the case where the password is null, log an error or throw an exception
            logger.error("Attempted to sign up with a null password for user: {}", user.getUsername());
            // You might want to return an error view or redirect to the signup page with an error message
            // For simplicity, I'm redirecting to the login page in case of an error
            return "redirect:/login?error=passwordNull";
        }

        // Redirect to the login page or any other desired page upon successful signup
        return "redirect:/login";
    }
}
