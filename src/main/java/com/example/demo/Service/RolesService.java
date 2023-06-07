package com.example.demo.Service;

import com.example.demo.Model.Project;
import com.example.demo.Model.Roles;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository ;
    public List<Roles> getAllRoles(){
        List<Roles> all = rolesRepository.findAll();
        return all;
    }

    public Optional<Roles> getRol(Long id){
        return rolesRepository.findById(id);
    }

    public Roles createRol (Roles roles){return rolesRepository.save(roles);
    }
    public  void deleteRol (Long id) {rolesRepository.deleteById(id);}

    public ResponseEntity<Roles> updateRol(Long id, Roles  roles){
        Optional<Roles> RolesData = rolesRepository.findById(id);

        if (RolesData.isPresent()) {
           Roles  _role = RolesData.get();
            _role.setCode(roles.getCode());
            _role.setLibelle(roles.getLibelle());


            return new ResponseEntity<>(rolesRepository.save( _role), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
