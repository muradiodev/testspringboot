package com.murad.online1.db.repository;

import com.murad.online1.db.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findAllBy();

    List<Employee> findAllByNameAndSurname(String name, String surname);


}
