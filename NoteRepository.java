package Notes.com.example.Notesdemo.repository;

import Notes.com.example.Notesdemo.entity.Notes;
import org.springframework.data.domain.ManagedTypes;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Notes,Integer> {


   List<Notes> getByUserId(int userId);

//   @Query("From notes where notes.id=:id")
//   Notes findById(@Param("id") int id);


}
