package com.childrights.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.childrights.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

 User findByUsername(String username);

}
