package ToDoList.ToDo.App.SERVICE;

import ToDoList.ToDo.App.DTO.ToDoResponse;
import ToDoList.ToDo.App.DTO.TodoRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface TodoService {
    ToDoResponse create(@Valid TodoRequest request);

    List<ToDoResponse> getAll();

    ToDoResponse getdById(Long id);

    ToDoResponse update(Long id, @Valid TodoRequest request);

    void delete(Long id);
}
