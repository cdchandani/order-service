package com.chanchal.futures.repository;

import com.chanchal.futures.bo.OrderBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderBO, Long> {

}
