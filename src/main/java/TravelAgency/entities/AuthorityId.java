package TravelAgency.entities;

import java.io.Serializable;

public class AuthorityId implements Serializable {

    private String authority;
    private String user; // Should match the type of the username field in User entity

    // Default constructor
    public AuthorityId() {
        // default constructor
    }

    // Constructor with parameters for the composite key
    public AuthorityId(String authority, String user) {
        this.authority = authority;
        this.user = user;
    }

    // Additional constructors, getters, and setters as needed

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    // Convenience method to create an AuthorityId for ROLE_ADMIN
    public static AuthorityId createForAdmin(String username) {
        return new AuthorityId("ROLE_ADMIN", username);
    }

    // Convenience method to create an AuthorityId for ROLE_USER
    public static AuthorityId createForUser(String username) {
        return new AuthorityId("ROLE_USER", username);
    }
}
