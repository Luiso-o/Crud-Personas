package CrudMongoDocker.crud.document;

import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "personas")
public class Persona {

    @MongoId
    private UUID idPersona;
    private String nombre;
    private int edad;
    private double estatura;
    private int pesoKg;
}
