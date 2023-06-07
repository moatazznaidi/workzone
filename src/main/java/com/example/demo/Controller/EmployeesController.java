package com.example.demo.Controller;

import com.example.demo.Model.EmpDTO;
import com.example.demo.Model.Employees;
import com.example.demo.Model.ImageModel;
import com.example.demo.Model.Tasks;
import com.example.demo.Repository.EmployeesRepository;
import com.example.demo.Service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.midi.ShortMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class EmployeesController {
    @Autowired
    EmployeesService employeesService;
    @Autowired
    private EmployeesRepository employeeRepository;


    @GetMapping("/employees")
    public List<Employees> getAllUsers() {

         List all= employeesService.getAllUsers();
        return all;
    }
    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(
            value = "/employees/img/{id}",
            produces = "application/json",
            method = RequestMethod.POST)
    public String createfile(@RequestParam MultipartFile file,@PathVariable Long id
    ) throws IOException {
        System.out.println(file);
        System.out.println(id);
        Optional<Employees> a =employeesService.getuserbyid(id);
        a.get().setPicture(file.getBytes());
        employeeRepository.save(a.get());
        return " success)";}

    @GetMapping("/employees/{id}")
    public Optional<Employees> getEmployees(@PathVariable Long id){
        return employeesService.getEmployees(id); }


    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(
            value = "/employees",
            produces = "application/json",
            method = RequestMethod.POST)
    public Employees createEmployee(@RequestBody Employees employee
                                                    ) throws IOException {

        if ( employeesService.createEmp(employee)) {

            return employee;
        }
        return employee;
    }





    @RequestMapping(value="/employees/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAEmployee(@PathVariable Long id){
        employeesService.deleteEmp(id);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employees> UpdateEmployee(@PathVariable Long id, @RequestBody Employees employees){
        return employeesService.updateEmp(id,employees);
    }
}
