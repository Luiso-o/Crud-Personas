package CrudMongoDocker.crud.helper;

import CrudMongoDocker.crud.document.Persona;
import CrudMongoDocker.crud.dto.PersonaDto;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

@Component
public class MetodosPersona {
    private static final Logger log = LoggerFactory.getLogger(MetodosPersona.class);

    public PersonaDto convertirDocumentoADto(Persona persona){
        log.info("Convirtiendo el objeto Document a Dto...");
        return PersonaDto.builder()
                .idPersona(persona.getIdPersona())
                .nombre(persona.getNombre())
                .edad(persona.getEdad())
                .estatura(persona.getEstatura())
                .pesoKg(persona.getPesoKg())
                .build();
    }

}
