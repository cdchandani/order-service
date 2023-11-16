package com.chanchal.futures.repository;

import com.chanchal.futures.bo.ApplicationErrorBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationErrorRepository extends JpaRepository<ApplicationErrorBO, Long>{}
