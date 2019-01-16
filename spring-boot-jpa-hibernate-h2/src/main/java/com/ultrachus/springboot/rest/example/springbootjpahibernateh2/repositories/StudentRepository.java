package com.ultrachus.springboot.rest.example.springbootjpahibernateh2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ultrachus.springboot.rest.example.springbootjpahibernateh2.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
