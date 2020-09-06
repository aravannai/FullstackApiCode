package com.example.rest.webservice.todoservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJPARepository extends JpaRepository<Todo, Long> {
	List<Todo> findByUserName(String userName);
}
