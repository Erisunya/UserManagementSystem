package com.cognizant.bank.repositories;

import java.util.Optional;

import com.cognizant.bank.entities.Token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TokenRepository extends JpaRepository<Token, Integer> {
	
	Optional<Token> findByTokenString(String tokenString);
}
