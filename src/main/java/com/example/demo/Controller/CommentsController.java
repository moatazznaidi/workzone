package com.example.demo.Controller;

import com.example.demo.Model.Comments;
import com.example.demo.Service.CommentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")

@RequestMapping("/api")
public class CommentsController {

    @Autowired
    private CommentsServices commentsServices ;

    @GetMapping("/Comments")
    public List<Comments> getAllComments() {

        List all= commentsServices.getAllComments();
        return all;
    }

    @GetMapping("/Comments/{id}")
    public Optional<Comments> getComment(@PathVariable Long id){
        return commentsServices.getComment(id); }

    @PostMapping(value = "/Comments")
    public Comments createComment (@RequestBody Comments comments) {
        return commentsServices.createComment (comments);}

    @RequestMapping(value="/Comments/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@PathVariable Long id){
        commentsServices.deleteComment(id);
    }

    @PutMapping("/Comments/{id}")
    public ResponseEntity<Comments> UpdateComments(@PathVariable Long id, @RequestBody Comments comments){
        return commentsServices.UpdateComments(id,comments);
    }

}
