package ServerTest.ServerTest.repository;

import ServerTest.ServerTest.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
