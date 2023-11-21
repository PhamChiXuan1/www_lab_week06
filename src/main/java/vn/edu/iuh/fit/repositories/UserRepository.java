package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPasswordHash(String email, String passwordHash);
    User findByEmail(String email);
}
