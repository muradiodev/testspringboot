package com.murad.online1.services.impl;

import com.murad.online1.client.EmployeeLogsClient;
import com.murad.online1.client.internal.EmployeeLogs;
import com.murad.online1.db.entity.Address;
import com.murad.online1.db.entity.Employee;
import com.murad.online1.db.repository.AddressRepository;
import com.murad.online1.db.repository.EmployeeRepository;
import com.murad.online1.mapper.EmployeeMapper;
import com.murad.online1.model.dto.EmployeeDto;
import com.murad.online1.services.MyService;
import com.murad.online1.utility.response.GenerateResponseUtility;
import com.murad.online1.utility.response.ResponseData;
import com.murad.online1.utility.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyServiceImpl implements MyService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final EmployeeLogsClient employeeLogsClient;



    @Override
    public ResponseData<Employee> create(Employee employee) {
        log.info("creating new employee  {}",employee);
        try {
            Employee saved = employeeRepository.save(employee);
            return ResponseData.<Employee>builder()
                    .code(Constants.SUCCESS_CODE)
                    .message(Constants.SUCCESS_MESSAGE)
                    .data(saved)
                    .build();
        }catch (Exception e) {
            log.error("Error saving employee : {}  error : {}", employee, e, e);
            return ResponseData.<Employee>builder()
                    .code(Constants.ERROR_FOUND)
                    .message(Constants.ERROR_MESSAGE)
                    .build();
        }
    }


    @Override
    public ResponseData<List<Employee>> getAllNames() {
        log.info("getting all names from db");
        List<Employee> allEmps = employeeRepository.findAllBy();
        if (allEmps.isEmpty()) {
            log.info("not found");
            return ResponseData.<List<Employee>>builder()
                    .code(Constants.NOT_FOUND_CODE)
                    .message(Constants.NOT_FOUND_MESSAGE)
                    .data(new ArrayList<>())
                    .build();
        } else {
            log.info("all employees : {}", allEmps);
            return ResponseData.<List<Employee>>builder()
                    .code(Constants.SUCCESS_CODE)
                    .message(Constants.SUCCESS_MESSAGE)
                    .data(allEmps)
                    .build();
        }
    }

    @Override
    public ResponseData<Employee> getById(int idEmployee) {
        Optional<Employee> employee = employeeRepository.findById(idEmployee);
        if(employee.isPresent()) {
            log.info("found employee : {}", employee);
            return GenerateResponseUtility.employeeFunc.generate(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, employee.get());
        } else {
            return GenerateResponseUtility.employeeFunc.generate(Constants.NOT_FOUND_CODE, Constants.NOT_FOUND_MESSAGE, null);
        }
    }

    @Override
    public ResponseData<EmployeeDto> getEmployeeWithAddressById(int idEmp) {
        Optional<Employee> employee = employeeRepository.findById(idEmp);
        if (employee.isPresent()) {
            Address empAddress = addressRepository.findByIdEmployee(idEmp);
            EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapToEmpDto(employee.get());
            employeeDto.setAddress(empAddress);
            return GenerateResponseUtility.employeeDtoFunc.generate(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, employeeDto);
        }
        return GenerateResponseUtility.employeeDtoFunc.generate(Constants.NOT_FOUND_CODE, Constants.NOT_FOUND_MESSAGE, null);
    }


    @Override
    public ResponseData<List<EmployeeLogs>> getEmpLogs(int idEmp) {
        ResponseEntity<ResponseData<List<EmployeeLogs>>> response = employeeLogsClient.getEmpLogs(idEmp);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null && response.getBody().getCode() == Constants.SUCCESS_CODE) {
            return GenerateResponseUtility.empLogsFunc.generate(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, response.getBody().getData());
        }

        return GenerateResponseUtility.empLogsFunc.generate(Constants.NOT_FOUND_CODE, Constants.NOT_FOUND_MESSAGE, null);

    }
}
