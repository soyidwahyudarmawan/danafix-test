package com.test.danafixtest.service;

import com.test.danafixtest.dto.request.EmployeeRequestSaveDto;
import com.test.danafixtest.dto.response.EmployeeResponseDto;
import com.test.danafixtest.dto.response.Response;
import com.test.danafixtest.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDto> findEmployeesById(String id);
    List<EmployeeResponseDto> findAll();
    EmployeeResponseDto createEmployee(EmployeeRequestSaveDto request);
    EmployeeResponseDto updateEmployee(String id, EmployeeRequestSaveDto request);
    ResponseEntity<HttpStatus> deleteEmployee(String id);
    List<EmployeeResponseDto> findEmployeesByYear(LocalDate birthDate);
}
