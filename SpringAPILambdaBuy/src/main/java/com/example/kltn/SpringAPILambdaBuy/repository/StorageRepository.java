package com.example.kltn.SpringAPILambdaBuy.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.kltn.SpringAPILambdaBuy.entities.ImageEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;

@Repository
@Transactional
public interface StorageRepository extends JpaRepository<ImageEntity, String> {
	@Query(value = "SELECT * FROM image i WHERE i.name = ?1", nativeQuery = true)
	Optional<ImageEntity> findByName(String name);
}
