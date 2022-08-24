package com.test.danafixtest.mapper.impl;

import com.test.danafixtest.dto.request.EmployeeRequestSaveDto;
import com.test.danafixtest.dto.response.EmployeeResponseDto;
import com.test.danafixtest.entity.Employee;
import com.test.danafixtest.entity.Employee.EmployeeBuilder;
import com.test.danafixtest.mapper.EmployeeMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public EmployeeResponseDto responseEmployee(Employee employee) {
        EmployeeResponseDto response = new EmployeeResponseDto();
        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setBirthPlace(employee.getBirthPlace());
        response.setBirthDate(employee.getBirthDate());
        response.setAddress(employee.getAddress());
        response.setMobilePhone(employee.getMobilePhone());
        return response;
    }

    @Override
    public Employee requestEmployee(EmployeeRequestSaveDto request) {
        if(request == null){
            return null;
        }
        EmployeeBuilder builder = Employee.builder();
        builder.name(request.getName());
        builder.birthPlace(request.getBirthPlace());
        builder.birthDate(request.getBirthDate());
        builder.address(request.getAddress());
        builder.mobilePhone(request.getMobilePhone());
        return builder.build();
    }

    @Override
    public void requestUpdateEmployee(EmployeeRequestSaveDto request, Employee employee) {
        if (request == null){
            return;
        }
        if (request.getName() != null){
            employee.setName(request.getName());
        }
        if (request.getBirthPlace() != null){
            employee.setBirthPlace(request.getBirthPlace());
        }
        if (request.getBirthDate() != null){
            employee.setBirthDate(request.getBirthDate());
        }
        if (request.getAddress() != null){
            employee.setAddress(request.getAddress());
        }
        if (request.getMobilePhone() != null){
            employee.setMobilePhone(request.getMobilePhone());
        }
    }
}
