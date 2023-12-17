package TravelAgency.repositories;

import TravelAgency.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
    // You may add custom query methods if needed
}
