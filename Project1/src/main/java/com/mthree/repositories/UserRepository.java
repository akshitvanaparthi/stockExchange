package com.mthree.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	
	@Query(
			value="SELECT id, username, password FROM user u "
					+ "WHERE u.username  = :username AND u.password = :password"
			,nativeQuery = true)
	public Optional<User> loginUser(@Param("username") String username,
							@Param("password")String password);
	
}
