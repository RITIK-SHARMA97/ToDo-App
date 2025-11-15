package ToDoList.ToDo.App.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToDoResponse {

    private Long id;
    private String title;
    private String description;
    private boolean completedAt;
    private Instant createdAt;
    private  Instant updatedAt;


}
