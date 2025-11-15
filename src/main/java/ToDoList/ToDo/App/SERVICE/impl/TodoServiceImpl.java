package ToDoList.ToDo.App.SERVICE.impl;

import ToDoList.ToDo.App.DTO.ToDoResponse;
import ToDoList.ToDo.App.DTO.TodoRequest;
import ToDoList.ToDo.App.ENTITY.Todo;
import ToDoList.ToDo.App.EXCEPTION.TodoNotFoundException;
import ToDoList.ToDo.App.MAPPER.TodoMapper;
import ToDoList.ToDo.App.REPOSITORY.TodoRepository;
import ToDoList.ToDo.App.SERVICE.TodoService;
//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
//import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor


public class TodoServiceImpl implements TodoService {
    private  final TodoRepository repository;
    private final TodoMapper mapper;

    @Override
    @Transactional
    public ToDoResponse create(TodoRequest request) {
       Todo entity = mapper.toEntity(request);
       Todo saved = repository.save(entity);
       return mapper.toResponse(saved);

    }

    @Override
    @Transactional(readOnly = true)
    public List<ToDoResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ToDoResponse getdById(Long id) {
        Todo t = repository.findById(id).orElseThrow(()-> new TodoNotFoundException(id));
        return mapper.toResponse(t);
    }

    @Override
    @Transactional
    public ToDoResponse update(Long id, TodoRequest request) {
        Todo existing = repository.findById(id).orElseThrow(()-> new TodoNotFoundException(id));

        existing.setTitle(request.getTitle());
        existing.setDescription(request.getDescription());
        existing.setCompleted(Boolean.TRUE.equals(request.getCompleted()));

        Todo saved =repository.save(existing);
        return  mapper.toResponse(saved);


    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)) throw new TodoNotFoundException(id);
        repository.deleteById(id);
    }
}
