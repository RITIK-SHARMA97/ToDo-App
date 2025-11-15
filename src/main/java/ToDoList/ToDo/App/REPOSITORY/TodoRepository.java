package ToDoList.ToDo.App.REPOSITORY;

import ToDoList.ToDo.App.ENTITY.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
}
