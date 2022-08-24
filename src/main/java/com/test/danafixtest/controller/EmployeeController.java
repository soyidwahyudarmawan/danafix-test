package com.test.danafixtest.controller;

import com.test.danafixtest.dto.request.EmployeeRequestSaveDto;
import com.test.danafixtest.dto.response.EmployeeResponseDto;
import com.test.danafixtest.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@RequestBody EmployeeRequestSaveDto employeeRequestSaveDto){
        return ResponseEntity.ok(employeeService.save(employeeRequestSaveDto));
    }

    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EmployeeResponseDto> findEmployeesById(@PathVariable(name = "id")String id){
        return  employeeService.findEmployeesById(id);
    }

    @GetMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EmployeeResponseDto> findAll(){
        return employeeService.findAll();
    }

    @PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    EmployeeResponseDto createEmployee(@RequestBody EmployeeRequestSaveDto request){
        return employeeService.createEmployee(request);
    }

    @PutMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    EmployeeResponseDto updateEmployee(@PathVariable(name = "id")String id, @RequestBody EmployeeRequestSaveDto request){
        return employeeService.updateEmployee(id,request);
    }

    @DeleteMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String id){
        return employeeService.deleteEmployee(id);
    }
}
