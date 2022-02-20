package com.murad.online1.services;

import com.murad.online1.client.internal.EmployeeLogs;
import com.murad.online1.db.entity.Employee;
import com.murad.online1.model.dto.EmployeeDto;
import com.murad.online1.utility.response.ResponseData;

import java.util.List;

public interface MyService {

    ResponseData<Employee> create(Employee employee);

    ResponseData<List<Employee>> getAllNames();

    ResponseData<Employee> getById(int idEmployee);

    ResponseData<EmployeeDto> getEmployeeWithAddressById(int idEmp);

    ResponseData<List<EmployeeLogs>> getEmpLogs(int idEmp);
}
