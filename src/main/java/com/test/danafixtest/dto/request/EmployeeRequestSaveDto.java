package com.test.danafixtest.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestSaveDto {
    @NotNull
    private String name;

    @NotNull
    private String birthPlace;

    String str = "13/11/2020";

    @NotNull
    private LocalDate birthDate = LocalDate.parse(str, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    @NotNull
    private String address;

    @NotNull
    private String mobilePhone;
}
