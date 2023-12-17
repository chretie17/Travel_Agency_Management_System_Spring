package TravelAgency.services;

import TravelAgency.entities.Authority;
import TravelAgency.entities.User;
import TravelAgency.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        // Encode the user's password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user to the database
        userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findById(username);
    }

    public void makeUserAdmin(String username) {
        User user = userRepository.findById(username).orElse(null);

        if (user != null && !hasAdminAuthority(user)) {
            // Create an Authority with "ROLE_ADMIN" and associate it with the user
            Authority adminAuthority = new Authority();
            adminAuthority.setAuthority("ROLE_ADMIN");
            adminAuthority.setUser(user);

            // Add the new authority to the user's authorities
            user.getAuthorities().add(adminAuthority);

            // Save the updated user
            userRepository.save(user);
        }
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public User getUserByUsername(String username) {
        return userRepository.findById(username).orElse(null);
    }

    public void updateUser(User updatedUser) {
        // Get the existing user from the database
        User existingUser = userRepository.findById(updatedUser.getUsername()).orElse(null);

        // Update the user details if the user exists
        if (existingUser != null) {
            existingUser.setEmail(updatedUser.getEmail());
            // Update other fields as needed

            // Save the updated user
            userRepository.save(existingUser);
        }
    }

    // Helper method to check if the user already has the "ROLE_ADMIN" authority
    private boolean hasAdminAuthority(User user) {
        return user.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
    }
}
