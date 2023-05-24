package Notes.com.example.Notesdemo.service;

import Notes.com.example.Notesdemo.entity.Notes;
import Notes.com.example.Notesdemo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NoteRepository noteRepository;


    public List<Notes> findAll(int page, int size, String Title ){


        return noteRepository.findAll(PageRequest.of(page,size, Sort.by(Title).ascending())).toList();

    }




    public  List<Notes> TrainDetails(@RequestParam int page, @RequestParam int size, @RequestParam String title){
        PageRequest pr=PageRequest.of(page,size, Sort.Direction.valueOf(title));
        return (List<Notes>) noteRepository.findAll(pr);
    }
}
