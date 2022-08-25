package com.test.danafixtest.controller;

import com.test.danafixtest.dto.request.EmployeeRequestSaveDto;
import com.test.danafixtest.dto.response.EmployeeResponseDto;
import com.test.danafixtest.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EmployeeResponseDto> findEmployeesById(@PathVariable(name = "id")String id){
        return  employeeService.findEmployeesById(id);
    }

    @GetMapping(value = "/employee/year", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeResponseDto> findEmployeesByYear(@RequestParam("birthDate")
                                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate birthDate){
        return employeeService.findEmployeesByYear(birthDate);
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
