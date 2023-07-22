package com.example.kltn.SpringAPILambdaBuy.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;

@Repository
@Transactional
public interface SupplierRepository extends JpaRepository<SupplierEntity, String> {
	@Query(value = "SELECT * FROM supplier s WHERE s.name = ?1", nativeQuery = true)
	SupplierEntity findByName(String name);
}
