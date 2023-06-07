package com.example.demo.Service;

import com.example.demo.Model.EmplProj;
import com.example.demo.Repository.EmplProjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmplProjService {
    @Autowired
    private EmplProjRepository emplProjRepository;

    public List<EmplProj> getAllEmplProj(){
        List<EmplProj> all = emplProjRepository.findAll();
        return all;
    }

    public Optional<EmplProj> getEmplProj(Long id){
        return  emplProjRepository.findById(id);
    }

    public EmplProj createEmplProj (EmplProj emplProj){return  emplProjRepository.save(emplProj);}

    public  void deleteEmplProj(Long id) { emplProjRepository.deleteById(id);}

    public ResponseEntity<EmplProj> updateEmplProj(Long id, EmplProj emplProj){
        Optional<EmplProj> EmplProjData = emplProjRepository.findById(id);

        if (EmplProjData.isPresent()) {
            EmplProj  _emplProj  = EmplProjData.get();
            _emplProj.setId_employee(emplProj.getId_employee());
            _emplProj.setId_project(emplProj.getId_project());
            _emplProj.setId_role(emplProj.getId_role());
            return new ResponseEntity<>(emplProjRepository.save( _emplProj), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
