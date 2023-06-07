package com.example.demo.Controller;

import com.example.demo.Model.Team;
import com.example.demo.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class TeamController {

    @Autowired
    TeamService teamService ;

    @GetMapping("/team")
    public List<Team> getAllProject() {

        List all= teamService.getAllTeam();
        return all;
    }

    @GetMapping("/team/{id}")
    public Optional<Team> getTeam(@PathVariable Long id){
        return  teamService.getTeam(id); }

    @PostMapping(value = "/team" )
    public Team createTeam(@RequestBody Team team) {
        return teamService.createemployeerole(team);}

    @RequestMapping(value="/team/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTeam(@PathVariable Long id){
        teamService.deleteTeam(id);
    }

    @PutMapping("/team/{id}")
    public ResponseEntity<Team> UpdateTeam(@PathVariable Long id, @RequestBody Team team){
        return teamService.updateTeam(id,team);
    }

}
