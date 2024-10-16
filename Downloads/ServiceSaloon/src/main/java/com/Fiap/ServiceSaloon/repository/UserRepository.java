package com.Fiap.ServiceSaloon.repository;

import org.springframework.stereotype.Repository;

import com.Fiap.ServiceSaloon.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findFirstByEmail(String email);

}
