package com.sparta.group3.northwindtask.northwindtask.repos;

import com.sparta.group3.northwindtask.northwindtask.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}