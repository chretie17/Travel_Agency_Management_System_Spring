package TravelAgency.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
@IdClass(AuthorityId.class)
public class Authority implements Serializable {

    @Id
    @Column(name = "authority")
    private String authority;

    @Id
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    // Constructors, getters, and setters

    // No-arg constructor (required by JPA)
    public Authority() {
    }

    // Constructor with parameters for the composite key
    public Authority(String authority, User user) {
        this.authority = authority;
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Additional constructors, getters, and setters as needed

}
