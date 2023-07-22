package com.example.kltn.SpringAPILambdaBuy.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.kltn.SpringAPILambdaBuy.entities.OrderEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<OrderEntity, String> {
//	@Query(value = "SELECT * FROM orders o WHERE u.user_id = ?1", nativeQuery = true)
//	List<OrderEntity> findByUserId(String id);
	
//	@Query("SELECT o.id , p.name FROM orders o JOIN o.list_product p")
//	public String getJoinInfomation();
}
