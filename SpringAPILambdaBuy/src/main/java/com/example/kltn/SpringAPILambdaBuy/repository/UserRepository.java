package com.example.kltn.SpringAPILambdaBuy.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String> {
	@Query(value = "SELECT * FROM user u WHERE u.username = ?1", nativeQuery = true)
	UserEntity findByUsername(String username);
	
	@Query(value = "SELECT * FROM user u WHERE u.email = ?1", nativeQuery = true)
	UserEntity findByEmail(String email);
	
	public UserEntity getUserByEmailAndUsername(String email, String username);
}
