package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// @RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // That's it ... no need to write any code LOL!
}
