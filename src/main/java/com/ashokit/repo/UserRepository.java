package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ashokit.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	@Query("select email from Users u where u.email=:email and u.password=:password")
	public String login(@Param("email") String email, @Param("password") String password);

	@Query("select email from Users u where u.email=:email")
	public String checkEmail(@Param("email") String email);

	@Modifying
	@Query("update Users set password=:password,isUserUnlock=true where email=:email")
	public Integer userUnlock(@Param("password") String password, @Param("email") String email);

	@Query("select password from Users u where u.email=:email")
	public String getPassword(@Param("email") String email);

}
