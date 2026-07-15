package org.kazakov.textservice.repository;

import org.kazakov.textservice.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("SELECT n FROM Note n WHERE LOWER(n.content) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR LOWER(n.title) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Note> searchByText(@Param("query") String query);

}
