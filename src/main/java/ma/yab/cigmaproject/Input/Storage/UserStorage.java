package ma.yab.cigmaproject.Input.Storage;

import ma.yab.cigmaproject.Input.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStorage extends JpaRepository<User, Long> {
}
