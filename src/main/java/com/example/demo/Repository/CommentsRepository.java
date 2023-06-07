package com.example.demo.Repository;

import com.example.demo.Model.Comments;
import com.example.demo.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository  extends JpaRepository<Comments,Long> {


}
