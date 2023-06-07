package com.example.demo.Service;

import com.example.demo.Model.Team;
import com.example.demo.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeam(){
        List<Team> all = teamRepository.findAll();
        return all;
    }

    public Optional<Team> getTeam(Long id){
        return  teamRepository.findById(id);
    }

    public Team createteam (Team team){return  teamRepository.save(team);}

    public  void deleteTeam (Long id) { teamRepository.deleteById(id);}



    public ResponseEntity<Team> updateTeam(Long id, Team team){
        Optional<Team> TeamData = teamRepository.findById(id);

        if (TeamData.isPresent()) {
            Team  _team  = TeamData.get();
            _team.setId_employee(team.getId_employee());
            _team.setId_role(team.getId_role());

            return new ResponseEntity<>(teamRepository.save( _team), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public Team createemployeerole (Team team){
        return  teamRepository.save(team);
    }
}
