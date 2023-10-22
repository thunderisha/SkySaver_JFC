package al.jfc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import al.jfc.model.BookingUser;

public interface BookingUserRepository extends JpaRepository<BookingUser, Long>{

	@Query("SELECT b FROM BookingUser b WHERE b.userId = :userId")
	List<BookingUser> findByUserId(int userId);

}
