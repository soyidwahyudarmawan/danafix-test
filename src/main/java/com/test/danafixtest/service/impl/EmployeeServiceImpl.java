package com.test.danafixtest.service.impl;

import com.test.danafixtest.dto.request.EmployeeRequestSaveDto;
import com.test.danafixtest.dto.response.EmployeeResponseDto;
import com.test.danafixtest.dto.response.Response;
import com.test.danafixtest.entity.Employee;
import com.test.danafixtest.mapper.EmployeeMapper;
import com.test.danafixtest.repository.EmployeeRepository;
import com.test.danafixtest.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
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

    @Override
    public List<EmployeeResponseDto> findEmployeesById(String id) {
        var listEmployee = employeeRepository.findEmployeeById(id);
        return listEmployee.stream().map(employeeMapper::responseEmployee).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        var listEmployee = employeeRepository.findAllEmployee();
        return listEmployee.stream().map(employeeMapper ::responseEmployee).collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestSaveDto request) {
        var employee = employeeMapper.requestEmployee(request);
        var result = employeeRepository.save(employee);
        return employeeMapper.responseEmployee(result);
    }

    @Override
    public EmployeeResponseDto updateEmployee(String id, EmployeeRequestSaveDto request) {
        var employeeCheck = employeeRepository.findEmployeeById(id);
        var employeeUpdate = employeeCheck.get(0);
        employeeMapper.requestUpdateEmployee(request,employeeUpdate);
        var result = employeeRepository.save(employeeUpdate);
        return employeeMapper.responseEmployee(result);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteEmployee(String id) {
        try {
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
