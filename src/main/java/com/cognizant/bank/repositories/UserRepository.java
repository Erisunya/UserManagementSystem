package com.cognizant.bank.repositories;

import java.util.Optional;

import com.cognizant.bank.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUsername(String username);
	
	Optional<User> findByUsernameAndPassword(String username, String password);

}
