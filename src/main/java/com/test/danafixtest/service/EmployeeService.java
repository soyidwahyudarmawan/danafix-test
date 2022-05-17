package com.test.danafixtest.service;

import com.test.danafixtest.dto.EmployeeRequestSaveDto;
import com.test.danafixtest.dto.Response;
import com.test.danafixtest.entity.Employee;
import com.test.danafixtest.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Response<Employee> save(EmployeeRequestSaveDto employeeRequestSaveDto) {
        return Response.result(employeeRepository.save(
                Employee.builder()
                .name(employeeRequestSaveDto.getName())
                .birthDate(employeeRequestSaveDto.getBirthDate())
                .address(employeeRequestSaveDto.getAddress())
                .birthPlace(employeeRequestSaveDto.getBirthPlace())
                .mobilePhone(employeeRequestSaveDto.getMobilePhone())
                .build()));
    }
}
