package Notes.com.example.Notesdemo.controller;

import Notes.com.example.Notesdemo.entity.Notes;
import Notes.com.example.Notesdemo.repository.NoteRepository;
import Notes.com.example.Notesdemo.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
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


    @GetMapping("/Notes/{id}")
    public Optional<Notes> findById(@PathVariable("id") int id) {
        return noteRepository.findById(id);
    }

    @GetMapping("/Notes/UserId")
    public ResponseEntity<?> getByUserId(@RequestParam("userId") int userId) {

        return new ResponseEntity<>(noteRepository.getByUserId(userId), HttpStatus.OK);
    }



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
        var imp = noteRepository.findById(id);
        if (imp.isPresent()) {
            var notes = imp.get();
            notes.setImportant(important);
            noteRepository.save(notes);
            return notes;
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notes Id is Not Found");
    }

    @GetMapping("/Notes")
    public List<Notes> notes(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "3") int pageSize, @PathVariable String sortByTitle) {
        return (List<Notes>) noteService.findAll(pageNumber, pageSize, sortByTitle);

    }

    @GetMapping("/notes")
    public ResponseEntity<List<Notes>> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
                                                       @RequestParam(defaultValue = "2") Integer pageSize,
                                                       @RequestParam(defaultValue = "title") String sortBy,
                                                       @RequestParam(defaultValue = "content") String sortByContent)
    {
        List<Notes> list = noteService.getAllEmployees(pageNo, pageSize, sortBy,sortByContent);
        return new ResponseEntity<List<Notes>>(list, new HttpHeaders(), HttpStatus.OK);
    }




}
