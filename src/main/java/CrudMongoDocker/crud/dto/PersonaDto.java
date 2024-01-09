package CrudMongoDocker.crud.dto;

import lombok.*;
import java.util.UUID;

@Data
@Getter
@Builder
public class PersonaDto {
    private UUID idPersona;
    private String nombre;
    private int edad;
    private double estatura;
    private int pesoKg;
}
