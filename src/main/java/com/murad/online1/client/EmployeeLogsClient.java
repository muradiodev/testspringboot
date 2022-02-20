package com.murad.online1.client;


import com.murad.online1.client.internal.EmployeeLogs;
import com.murad.online1.utility.response.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "emp-logs", url = "http://localhost:9876/emp-logs")
public interface EmployeeLogsClient {

    @GetMapping("/get-emp-logs/{idEmp}")
    ResponseEntity<ResponseData<List<EmployeeLogs>>> getEmpLogs(@PathVariable int idEmp);
}
