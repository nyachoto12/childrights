package com.childrights.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.childrights.model.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
	
}
