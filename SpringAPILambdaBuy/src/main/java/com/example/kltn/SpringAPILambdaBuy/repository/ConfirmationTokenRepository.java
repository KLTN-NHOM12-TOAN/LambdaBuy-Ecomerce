package com.example.kltn.SpringAPILambdaBuy.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kltn.SpringAPILambdaBuy.entities.ConfirmationTokenEntity;

@Repository
@Transactional
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationTokenEntity, String> {
	
	@Query(value = "SELECT * FROM token t WHERE t.token_code = ?1", nativeQuery = true)
	ConfirmationTokenEntity findByToken(String token_code);
}
