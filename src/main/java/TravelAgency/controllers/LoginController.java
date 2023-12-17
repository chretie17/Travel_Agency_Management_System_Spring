package TravelAgency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/login-success")
    public String loginSuccess(Model model) {
        model.addAttribute("loginSuccess", true);
        return "redirect:/index";
    }

    @PostMapping("/logout-success")
    public String logoutSuccess(Model model) {
        model.addAttribute("logoutSuccess", true);
        return "redirect:/login?logout";
    }


}
