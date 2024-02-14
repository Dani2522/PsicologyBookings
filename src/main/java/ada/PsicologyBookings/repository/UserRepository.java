package ada.PsicologyBookings.repository;


import ada.PsicologyBookings.domain.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findByfullName(String fullName);
    Optional<User> findById(Long id);
}
