package ToDoList.ToDo.App.CONFIG;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(


    info = @Info(title = "ToDo API", version = "1.0",description = "Simple Todo App API")
)
public class OpenApiConfig {
}
