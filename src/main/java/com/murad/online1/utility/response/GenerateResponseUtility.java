package com.murad.online1.utility.response;

import com.murad.online1.client.internal.EmployeeLogs;
import com.murad.online1.db.entity.Employee;
import com.murad.online1.model.dto.EmployeeDto;

import java.util.List;

public class GenerateResponseUtility {

    public static GenerateResponse<Integer, String, Employee, ResponseData<Employee>> employeeFunc = (code, message, data) ->
            ResponseData.<Employee>builder()
                    .code(code)
                    .message(message)
                    .data(data)
                    .build();

    public static GenerateResponse<Integer, String, EmployeeDto, ResponseData<EmployeeDto>> employeeDtoFunc = (code, message, data) ->
            ResponseData.<EmployeeDto>builder()
                    .code(code)
                    .message(message)
                    .data(data)
                    .build();

    public static GenerateResponse<Integer, String, List<EmployeeLogs>, ResponseData<List<EmployeeLogs>>> empLogsFunc = (code, message, data) ->
            ResponseData.<List<EmployeeLogs>>builder()
                    .code(code)
                    .message(message)
                    .data(data)
                    .build();
}
