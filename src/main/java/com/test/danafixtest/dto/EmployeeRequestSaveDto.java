package com.test.danafixtest.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestSaveDto {

    private String name;
    private String birthPlace;
    private LocalDate birthDate;
    private String address;
    private String mobilePhone;

}
