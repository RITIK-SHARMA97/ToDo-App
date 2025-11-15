package ToDoList.ToDo.App.CONTROLLER;

import ToDoList.ToDo.App.DTO.ToDoResponse;
import ToDoList.ToDo.App.DTO.TodoRequest;
import ToDoList.ToDo.App.SERVICE.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private  final TodoService todoService;
 @PostMapping
    public ResponseEntity<ToDoResponse> create( @Valid @RequestBody TodoRequest request){
        return  ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(request));
    }
     @GetMapping
    public ResponseEntity<List<ToDoResponse>> getAll(){
     return ResponseEntity.ok(todoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoResponse> getById(@PathVariable Long id){
     return ResponseEntity.ok(todoService.getdById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoResponse> update(@PathVariable Long id,@Valid @RequestBody TodoRequest request){
    return ResponseEntity.ok(todoService.update(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
     todoService.delete(id);
     return ResponseEntity.noContent().build();
    }



}
