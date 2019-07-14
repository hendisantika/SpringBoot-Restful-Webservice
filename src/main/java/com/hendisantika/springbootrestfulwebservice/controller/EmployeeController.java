package com.hendisantika.springbootrestfulwebservice.controller;

import com.hendisantika.springbootrestfulwebservice.model.Employee;
import com.hendisantika.springbootrestfulwebservice.service.EmployeeService;
import com.hendisantika.springbootrestfulwebservice.util.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-14
 * Time: 08:32
 */
@RestController
@RequestMapping(value = "/secure", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/allEmployee")
    public ResponseEntity<ServiceResponse> allEmployees() {
        @SuppressWarnings("static-access")
        Set<Employee> employees = employeeService.getEmpSet();
        ServiceResponse response = new ServiceResponse(true, "All employees");
        response.addParam("AllEmployee", employees);
        return new ResponseEntity<ServiceResponse>(response, HttpStatus.OK);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<ServiceResponse> employeeById(@PathVariable int employeeId) {
        Iterator<Employee> it = EmployeeService.getEmpSet().iterator();
        while (it.hasNext()) {
            Employee emp = it.next();
            if (emp.getId() == employeeId) {
                ServiceResponse response = new ServiceResponse(true, "Employee with id: " + employeeId);
                response.addParam("EmployeeById", emp);
                return new ResponseEntity<ServiceResponse>(response, HttpStatus.OK);
            }
        }
        ServiceResponse response = new ServiceResponse(true, "Employee with id: " + employeeId + " not available");
        return new ResponseEntity<ServiceResponse>(response, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<ServiceResponse> deleteEmployeeById(@PathVariable int employeeId) {

        Iterator<Employee> it = EmployeeService.getEmpSet().iterator();
        while (it.hasNext()) {
            Employee emp = it.next();
            if (emp.getId() == employeeId) {
                it.remove();
                ServiceResponse response = new ServiceResponse(true, "Employee with id: " + employeeId + " is deleted");
                return new ResponseEntity<ServiceResponse>(response, HttpStatus.OK);
            }
        }
        ServiceResponse response = new ServiceResponse(true,
                "Employee with id: " + employeeId + " is not avilable to delete");
        return new ResponseEntity<ServiceResponse>(response, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/employee")
    public ResponseEntity<ServiceResponse> addEmployeeWithPost(@RequestBody Employee emp) {
        Employee tempEmp = emp;
        int id = EmployeeService.getUniqueId();
        tempEmp.setId(id);
        EmployeeService.addEmpSet(tempEmp);
        ServiceResponse response = new ServiceResponse(true, "Employee Added Successfully");
        response.addParam(id + "", tempEmp);
        return new ResponseEntity<ServiceResponse>(response, HttpStatus.CREATED);
    }

    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<ServiceResponse> addEmployeeWithPut(@PathVariable int employeeId, @RequestBody Employee emp) {
        Iterator<Employee> it = EmployeeService.getEmpSet().iterator();
        while (it.hasNext()) {
            Employee tempEmp = it.next();
            if (tempEmp.getId() == employeeId) {
                tempEmp.setId(employeeId);
                tempEmp.setName(emp.getName());
                tempEmp.setSalary(emp.getSalary());
                ServiceResponse repsonse = new ServiceResponse(true,
                        "Employee with id " + employeeId + " is updated Successfully");
                repsonse.addParam(tempEmp.getId() + "", tempEmp);
                return new ResponseEntity<ServiceResponse>(repsonse, HttpStatus.OK);
            }
        }
        ServiceResponse response = new ServiceResponse(true, "Employee with id: " + employeeId + " not available");
        return new ResponseEntity<ServiceResponse>(response, HttpStatus.NOT_FOUND);
    }

}
