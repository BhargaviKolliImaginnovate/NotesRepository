package Notes.com.example.Notesdemo.controller;

import Notes.com.example.Notesdemo.entity.Notes;
import Notes.com.example.Notesdemo.repository.NoteRepository;
import Notes.com.example.Notesdemo.service.NotesService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class NotesController {


    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NotesService noteService;

//    @GetMapping("/Notes")
//    public List<Notes> getAllNotes() {
//        return noteRepository.findAll();
//    }


    @GetMapping(value = "/{id}")
    public Optional<Notes> findById(@PathVariable("id") int id) {
        return noteRepository.findById(id);
    }

    @GetMapping("/Notes/UserId")
    public ResponseEntity<?> getByUserId(@RequestParam("userId") int userId) {

        return new ResponseEntity<>(noteRepository.getByUserId(userId), HttpStatus.OK);
    }

//    @GetMapping("/Notes-Paging")
//    public List<Notes> Notes(@RequestParam(defaultValue = "0")int pageNumber, @RequestParam(defaultValue = "10") int pageSize, @PathVariable String sortByName){
//        return  notesRepository.Notes(pageNumber,pageSize,sortByName);
//    }

    @PostMapping("/Notes")
    public Notes save(@RequestBody Notes note) {
        return noteRepository.save(note);
    }


    @DeleteMapping("/Notes")
    public String deleteById(@RequestParam(value = "id") int id) {
        var notes = noteRepository.findById(id);
        if (notes.isPresent()) {
            noteRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note Id not found");
        }

        return "Delete by name called";
    }


    @PutMapping("/Notes/{Id}")
    public Notes update(@PathVariable("Id") int id, @RequestParam("important") boolean important) {
        var cat = noteRepository.findById(id);
        if (cat.isPresent()) {
            var notes = cat.get();
            notes.setImportant(important);
            noteRepository.save(notes);
            return notes;
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "room number is Not Found");
    }

    @GetMapping("/Notes")

    public List<Notes> findAll(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "3") int pageSize, @PathVariable String sortBytitle) {
        return (List<Notes>) noteService.findAll(pageNumber, pageSize, sortBytitle);

    }
}
