package com.test.danafixtest.mapper;

import com.test.danafixtest.dto.request.EmployeeRequestSaveDto;
import com.test.danafixtest.dto.response.EmployeeResponseDto;
import com.test.danafixtest.entity.Employee;

public interface EmployeeMapper {
    EmployeeResponseDto responseEmployee(Employee employee);
    Employee requestEmployee(EmployeeRequestSaveDto request);
    void requestUpdateEmployee(EmployeeRequestSaveDto request, Employee employee);
}
