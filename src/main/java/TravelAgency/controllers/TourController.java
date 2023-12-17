package TravelAgency.controllers;

import TravelAgency.entities.Tours;
import TravelAgency.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tours")
public class TourController {

    private final TourService tourService;

    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    // Mapping to handle the form submission and create a new tour
    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public String createTour(Tours tour) {
        // You may want to perform validation and error handling here
        tourService.saveTour(tour);
        return "redirect:/tours";  // Redirect to the tours page after creating a new tour
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/update/{id}")
    public String showUpdateTourForm(@PathVariable("id") Long id, Model model) {
        Tours tour = tourService.getProductById(id);
        model.addAttribute("tour", tour);
        return "updateTour";
    }

    // Mapping to handle the form submission and update a tour
    @Secured("ROLE_ADMIN")
    @PostMapping("/update/{id}")
    public String updateTour(@PathVariable("id") Long id, @ModelAttribute Tours updatedTour) {
        // You may want to perform validation and error handling here
        updatedTour.setId(id); // Set the ID from the path variable
        tourService.updateTour(updatedTour);
        return "redirect:/tours";  // Redirect to the tours page after updating the tour
    }

}
