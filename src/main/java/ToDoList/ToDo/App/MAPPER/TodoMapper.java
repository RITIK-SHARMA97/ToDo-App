package ToDoList.ToDo.App.MAPPER;

import ToDoList.ToDo.App.DTO.ToDoResponse;
import ToDoList.ToDo.App.DTO.TodoRequest;
import ToDoList.ToDo.App.ENTITY.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public Todo toEntity(TodoRequest req){
        return Todo.builder().title(req.getTitle()).description(req.getDescription()).completed(Boolean.TRUE.equals(req.getCompleted())).build();
    }

    public ToDoResponse toResponse(Todo t){
        if(t==null){
            return null;

        }
        return ToDoResponse.builder().id(t.getId()).title(t.getTitle()).description(t.getDescription()).completedAt(t.isCompleted()).createdAt(t.getCreatedAt()).updatedAt(t.getUpdatedAt()).build();
    }
}
