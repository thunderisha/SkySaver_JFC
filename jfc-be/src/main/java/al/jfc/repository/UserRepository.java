package al.jfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import al.jfc.model.User;

public interface UserRepository extends JpaRepository <User, Long>{

	User findById(long userId);

	@Query("SELECT u FROM User u WHERE u.email = :email")
	User findByEmail(String email);

}
