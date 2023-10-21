package al.jfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import al.jfc.model.User;

public interface UserRepository extends JpaRepository <User, Long>{

	User findById(long userId);

}
