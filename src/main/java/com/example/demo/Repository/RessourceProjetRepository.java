package com.example.demo.Repository;

import com.example.demo.Model.RessourceProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RessourceProjetRepository  extends JpaRepository<RessourceProjet,Long> {

    @Query(value="select r.\"name\"  \n" +
            "from ressourceproject r \n" +
            "where r.id_employee=:id ",nativeQuery=true)
    List<String> GetProjectByIdEmployee(@Param(value = "id") Long id);

}
