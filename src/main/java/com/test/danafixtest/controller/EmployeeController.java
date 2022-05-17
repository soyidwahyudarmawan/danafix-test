package com.test.danafixtest.controller;

import com.test.danafixtest.dto.EmployeeRequestSaveDto;
import com.test.danafixtest.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody EmployeeRequestSaveDto employeeRequestSaveDto){
        return ResponseEntity.ok(employeeService.save(employeeRequestSaveDto));
    }
}
