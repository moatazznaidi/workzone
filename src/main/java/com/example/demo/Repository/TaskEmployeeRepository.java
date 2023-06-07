package com.example.demo.Repository;

import com.example.demo.Model.VTaskEmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskEmployeeRepository  extends JpaRepository<VTaskEmp,Long> {
}
