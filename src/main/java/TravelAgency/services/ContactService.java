package TravelAgency.services;

import TravelAgency.entities.Contact;
import TravelAgency.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional
    public void processForm(Contact contact) {
        // Additional logic or validation if needed
        // Save the contact to the database
        contactRepository.save(contact);
    }

    @Transactional
    public void saveContact(Contact contact) {
        // Save the contact to the database
        contactRepository.save(contact);
    }
}
