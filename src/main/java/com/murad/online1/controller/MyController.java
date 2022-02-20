package com.murad.online1.controller;

import com.murad.online1.client.internal.EmployeeLogs;
import com.murad.online1.db.entity.Employee;
import com.murad.online1.model.dto.EmployeeDto;
import com.murad.online1.services.MyService;
import com.murad.online1.utility.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class MyController {


    private final MyService myService;

    @PostMapping("/with-params")
    private ResponseEntity<ResponseData<Employee>> create(@RequestParam String name,
                                                          @RequestParam String surname) {
        return ResponseEntity.ok(myService.create(Employee.builder().name(name).surname(surname).build()));
    }

    @PostMapping("/name/{name}/surname/{surname}")
    public ResponseEntity<ResponseData<Employee>> create2(@PathVariable String name,
                                                          @PathVariable String surname) {
        return ResponseEntity.ok(myService.create(Employee.builder().name(name).surname(surname).build()));
    }

    @PostMapping
    public ResponseData<Employee> create3(@RequestBody Employee employee) {
        return myService.create(employee);
    }

    @GetMapping
    private ResponseEntity<ResponseData<List<Employee>>> getAll() {
        return ResponseEntity.ok(myService.getAllNames());
    }


    @GetMapping("/id-emp/{idEmp}")
    public ResponseEntity<ResponseData<EmployeeDto>> getEmployeeById(@PathVariable int idEmp) {
        return ResponseEntity.ok(myService.getEmployeeWithAddressById(idEmp));
    }

    @GetMapping("/testing-service/{idEmp}")
    public ResponseEntity<ResponseData<List<EmployeeLogs>>> getLogs(@PathVariable int idEmp) {
        return ResponseEntity.ok(myService.getEmpLogs(idEmp));
    }

}
