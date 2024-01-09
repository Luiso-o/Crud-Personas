package CrudMongoDocker.crud.service;

import CrudMongoDocker.crud.dto.PersonaDto;

import java.util.Set;
import java.util.UUID;

public interface PersonaService {
    PersonaDto savePerson(String nombre, int edad, double estatura, int pesoKg);
    PersonaDto findPersonById(UUID idPerson);
    Set<PersonaDto> printPersonList();
    PersonaDto updatePerson(String nombre, int edad, double estatura, int pesoKg);
    void deletePerson(UUID idPerson);

}
