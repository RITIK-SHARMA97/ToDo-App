package ToDoList.ToDo.App.ENTITY;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table (name ="todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 200)
    private String description;

    @Column(nullable = false,updatable = false)
    private boolean completed = false;

    @Column(nullable = false,updatable = false)
    private Instant createdAt;

    private Instant updatedAt;

    @PrePersist
    public void prePersist(){
        createdAt=Instant.now();


    }

@PreUpdate
    public void preUpdate(){
        updatedAt=Instant.now();
    }
}
