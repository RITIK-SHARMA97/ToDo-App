package ToDoList.ToDo.App.EXCEPTION;

public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(Long id){
        super("Todo not found with id :" + id+ "not found");
    }
}
