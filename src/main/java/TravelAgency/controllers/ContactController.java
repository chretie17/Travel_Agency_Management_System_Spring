package TravelAgency.controllers;

import TravelAgency.entities.Contact;
import TravelAgency.services.ContactService;
import TravelAgency.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;
    private final EmailService emailService;

    @Autowired
    public ContactController(ContactService contactService, EmailService emailService) {
        this.contactService = contactService;
        this.emailService = emailService;
    }

    @PostMapping("/submitContactForm")
    @ResponseBody
    public String submitContactForm(@RequestBody Contact contact) {
        // You can add validation logic here if needed
        // Process the form data
        contactService.processForm(contact);

        // Save to the database
        contactService.saveContact(contact);

        // Send email
        emailService.sendEmail(contact.getName(), contact.getEmail(), contact.getSubject(), contact.getMessage());

        return "Form submitted successfully!";
    }
}
