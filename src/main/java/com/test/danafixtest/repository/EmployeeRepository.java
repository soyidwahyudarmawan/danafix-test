package com.test.danafixtest.repository;

import com.test.danafixtest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query(value = "SELECT * FROM Employee ", nativeQuery = true)
    List<Employee> findAllEmployee();

    @Query(value = "SELECT * FROM Employee WHERE id = :id", nativeQuery = true)
    List<Employee> findEmployeeById(@Param("id")String id);

    @Query(value = "SELECT * FROM Employee WHERE birth_date = :birthDate", nativeQuery = true)
    List<Employee> findEmployeeByYear(@Param("birthDate")LocalDate birthDate);
}
