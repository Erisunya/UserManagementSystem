package com.cognizant.bank.repositories;

import java.util.Optional;

import com.cognizant.bank.entities.Loan;
import com.cognizant.bank.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface LoanRepository extends JpaRepository<Loan, Integer> {
	
	Optional<Loan> findByUser(User user);
	
}
