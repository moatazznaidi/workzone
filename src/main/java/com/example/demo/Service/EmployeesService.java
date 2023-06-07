package com.example.demo.Service;

import com.example.demo.Model.Employees;
import com.example.demo.Model.Tasks;
import com.example.demo.Model.tool.Role;
import com.example.demo.Model.tool.User;
import com.example.demo.Repository.EmployeesRepository;
import com.example.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor

@Service
public class EmployeesService {
    private  final PasswordEncoder passwordEncoder ;

    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private UserRepository userRepository;

    public Employees saveEmployeToDB( String firstname, String lastname,
                           String description, String adress, Integer age,String password,  Long phoneNumber,String email , Date birthdayDate , String login,
                          String gender){
        Employees employee = new Employees();

        employee.setFirstName(firstname);
        employee.setEmail(email);
        employee.setLastName(lastname);
        employee.setAdress(adress);
        employee.setAge(age);
        employee.setPhoneNumber(phoneNumber);
        employee.setPassword(password);
        employee.setDescription(description);
        employee.setBirthdayDate(birthdayDate);

        employee.setLogin(login);
        employee.setGender(gender);

        employeesRepository.save(employee);
    return employee;
    }
    public  List<Employees> getAllUsers(){
        List<Employees> all = employeesRepository.findAll();
        return all;
    }
    public  Optional<Employees>  getuserbyid(Long id){

        return  employeesRepository.findById(id);
    }

    public Optional<Employees> getEmployees(Long id){
        return employeesRepository.findById(id);
    }

//    public Boolean createEmp (Employees employees){
//
//        User user = new User();
//        user.setEmail(employees.getEmail());
//        user.setFirstname(employees.getFirstName());
//        if (employees.getDescription()=="Admin"){
//            user.setRole(Role.Admin);
//
//        }else if (employees.getDescription()=="ProjectManager"){
//            user.setRole(Role.ProjectManager);
//
//
//        }
//    else if (employees.getDescription()=="User"){
//        user.setRole(Role.User);
//
//
//    }
//
//        user.setPassword(employees.getPassword());
//        user.setLastname(employees.getLastName());
//        employeesRepository.save(employees);
//        user.setId(Integer.parseInt(employees.getId().toString()));
//
//        userRepository.save(user);
//
//        if (user!=null){
//            return  true;
//        }
//        else {
//            return false ;
//
//        }
//
//    }
public Boolean createEmp(Employees employees) {
    User user = new User();
    user.setEmail(employees.getEmail());
    user.setFirstname(employees.getFirstName());

    if (employees.getDescription().equals("Admin")) {
        user.setRole(Role.Admin);
    } else if (employees.getDescription().equals("ProjectManager")) {
        user.setRole(Role.ProjectManager);
    } else if (employees.getDescription().equals("User")) {
        user.setRole(Role.User);
    }

    user.setPassword(passwordEncoder.encode(employees.getPassword()));
    employees.setPassword(passwordEncoder.encode(employees.getPassword()));
    user.setLastname(employees.getLastName());

    userRepository.save(user);
    employees.setIdUser(user.getId());
    employeesRepository.save(employees);

    if (user.getId() != null) {
        return true;
    } else {
        return false;
    }
}

    public  void deleteEmp(Long id) {employeesRepository.deleteById(id);}

    public ResponseEntity<Employees> updateEmp(Long id, Employees employees){
        Optional<Employees> EmployeeData = employeesRepository.findById(id);

        if (EmployeeData.isPresent()) {
            Employees  _employees  = EmployeeData.get();
            _employees.setFirstName(employees.getFirstName());
            _employees.setLastName(employees.getLastName());
            _employees.setAge(employees.getAge());
            _employees.setGender(employees.getGender());
            _employees.setEmail(employees.getEmail());
            _employees.setDescription(employees.getDescription());
            _employees.setPassword(employees.getPassword());
          _employees.setPicture(employees.getPicture());
            _employees.setPhoneNumber(employees.getPhoneNumber());
            _employees.setBirthdayDate(employees.getBirthdayDate());
            _employees.setAdress(employees.getAdress());

            return new ResponseEntity<>(employeesRepository.save(_employees), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
