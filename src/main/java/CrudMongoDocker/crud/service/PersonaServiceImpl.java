package CrudMongoDocker.crud.service;

import CrudMongoDocker.crud.document.Persona;
import CrudMongoDocker.crud.dto.PersonaDto;
import CrudMongoDocker.crud.helper.MetodosPersona;
import CrudMongoDocker.crud.repository.PersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonaServiceImpl implements PersonaService{
    private static final Logger log = LoggerFactory.getLogger(MetodosPersona.class);
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private MetodosPersona metodosPersona;

    @Transactional
    @Override
    public PersonaDto savePerson(String nombre, int edad, double estatura, int pesoKg) {
            Persona nuevaPersona = Persona.builder()
                    .idPersona(UUID.randomUUID())
                    .nombre(nombre)
                    .edad(edad)
                    .estatura(estatura)
                    .pesoKg(pesoKg)
                    .build();

            try {
                personaRepository.save(nuevaPersona);
                return metodosPersona.convertirDocumentoADto(nuevaPersona);

            } catch (DataAccessException e) {
                log.error("Error al guardar en la base de datos: " + e.getMessage());
                throw new RuntimeException("Error al guardar en la base de datos", e);
            }
    }

    @Override
    public PersonaDto findPersonById(UUID idPerson) {
        return null;
    }

    @Override
    public Set<PersonaDto> printPersonList() {
        try{
           List<Persona> personas = personaRepository.findAll();

            return personas.stream()
                    .map(persona ->
                    metodosPersona.convertirDocumentoADto(persona))
                    .collect(Collectors.toSet());

        }catch (Exception e){
            log.error("Error al encontrar la lista de personas en la base de datos: " + e.getMessage());
            throw new RuntimeException("Error al encontrar la lista de personas en la base de datos: " , e);
        }
    }

    @Override
    public PersonaDto updatePerson(String nombre, int edad, double estatura, int pesoKg) {
        return null;
    }

    @Override
    public void deletePerson(UUID idPerson) {

    }
}
