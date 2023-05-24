package Notes.com.example.Notesdemo.service;

import Notes.com.example.Notesdemo.entity.Notes;
import Notes.com.example.Notesdemo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NoteRepository noteRepository;


    public List<Notes> findAll(int page, int size, String id ){


        return noteRepository.findAll(PageRequest.of(page,size, Sort.by(String.valueOf(id)).descending())).toList();

    }


    public  List<Notes> notes( Integer page,  Integer size, String  title){
        PageRequest pr=PageRequest.of(page,size, Sort.Direction.valueOf(title));
        return (List<Notes>) noteRepository.findAll(pr);
    }


    public List<Notes> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy, String sortByContent) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortByContent));
        Page<Notes> pagedResult = noteRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Notes>();
        }
    }



}
