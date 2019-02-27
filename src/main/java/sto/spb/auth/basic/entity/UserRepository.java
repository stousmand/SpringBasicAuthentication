package sto.spb.auth.basic.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users, Long> {
	
	@Query("SELECT u FROM Users u WHERE u.userName=:userName AND u.userPassword=:userPass")
	public Users getUser(@Param("userName") String strUser, @Param("userPass") String strPass);
}
