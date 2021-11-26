package pt.unilabs.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;
import pt.unilabs.hackathon.entities.User;

/**
 * <Class description>
 *
 * @author Luís Alves
 */
@ResponseBody
public interface UserRepository extends JpaRepository<User, Integer> {
}
