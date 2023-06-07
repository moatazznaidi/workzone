package com.example.demo.Service;

import com.example.demo.Model.VTaskProjectProj;
import com.example.demo.Repository.VTaskprojectprojetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VTaskProjectProjService {
    @Autowired
    private VTaskprojectprojetRepository vtaskprojectprojetRepository ;

    public VTaskProjectProj findtaskprojById(Long id) {

        //return null;
        return vtaskprojectprojetRepository.findById(id).orElse(null);

    }

    public List<VTaskProjectProj> findAllTaskproj(){
        List<VTaskProjectProj> all = vtaskprojectprojetRepository.findAll();
        return all;
    }

}
