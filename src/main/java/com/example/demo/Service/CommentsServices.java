package com.example.demo.Service;

import com.example.demo.Model.Comments;
import com.example.demo.Model.Employees;
import com.example.demo.Repository.CommentsRepository;
import com.example.demo.Repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsServices {

    @Autowired
    private CommentsRepository commentsRepository ;

    public List<Comments> getAllComments(){
        List<Comments> all = commentsRepository.findAll();
        return all;
    }


    public Optional<Comments> getComment(Long id){
        return commentsRepository.findById(id);
    }

    public Comments createComment (Comments comments){
        return commentsRepository.save(comments);
    }
    public  void deleteComment(Long id) {commentsRepository.deleteById(id);}

    public ResponseEntity<Comments> UpdateComments(Long id, Comments  comments){
        Optional<Comments> CommentData = commentsRepository.findById(id);

        if (CommentData.isPresent()) {
            Comments  _comment  = CommentData.get();
            _comment .setDescription(comments.getDescription());
            _comment .setDate(comments.getDate());
            _comment .setCommenter(comments.getCommenter());


            return new ResponseEntity<>(commentsRepository.save( _comment), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }



}
