package user_service.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user_service.models.User;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
