package com.example.demo.Controller;

import com.example.demo.Model.Roles;
import com.example.demo.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RolesController {
    @Autowired
    private RolesService rolesService ;

    @GetMapping("/roles")
    public List<Roles> getAllRoles() {

        List all=  rolesService.getAllRoles();
        return all;
    }

    @GetMapping("/roles/{id}")
    public Optional<Roles> getRol(@PathVariable Long id){
        return rolesService.getRol(id); }


    @PostMapping(value = "/roles" )
    public Roles createRol(@RequestBody Roles roles) {
        return rolesService.createRol(roles);}

    @RequestMapping(value="/roles/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteRol(@PathVariable Long id){
        rolesService.deleteRol(id);
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<Roles> updateRol(@PathVariable Long id, @RequestBody Roles roles){
        return rolesService.updateRol(id,roles);
    }

}
