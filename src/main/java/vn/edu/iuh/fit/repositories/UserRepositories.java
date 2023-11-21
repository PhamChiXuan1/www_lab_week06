package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.User;

public interface UserRepositories extends JpaRepository<User, Long> {
}
