package CrudMongoDocker.crud.controller;

import CrudMongoDocker.crud.dto.PersonaDto;
import CrudMongoDocker.crud.service.PersonaServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "person")
@Validated
public class PersonaController {

    @Autowired
    private PersonaServiceImpl personaService;

    @ApiOperation(value = "Ingresa una persona a la base de datos", response = PersonaDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Persona guardada en la base de datos",
            content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PersonaDto.class)),
            }),
            @ApiResponse(responseCode = "500", description = "Error interno, revisar consola", content = @Content)
    })
    @PostMapping(value = "create")
    public ResponseEntity<PersonaDto> createPerson(
            @RequestParam @Valid @Pattern(regexp = "^[a-zA-Z]+( [a-zA-Z]+)*$") String nombre,
            @RequestParam @Min(value = 1) @Max(value = 110) int edad,
            @RequestParam @Min(value = 1) @Max(value = 280) double estatura,
            @RequestParam @Min(value = 1) @Max(value = 150) int pesoKg
    ) {
        PersonaDto nuevoRegistro = personaService.savePerson(nombre, edad, estatura, pesoKg);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRegistro);
    }

    @ApiOperation(value = "Ver lista de personas en la base de Datos", response = HashSet.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista creada con éxito",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PersonaDto.class)),
                    }),
            @ApiResponse(responseCode = "500", description = "Error interno, revisar consola", content = @Content)
    })
    @GetMapping(value = "getAll")
    public ResponseEntity<Set<PersonaDto>> printPersonsList(){
        Set<PersonaDto>personaDtos = personaService.printPersonList();
        return ResponseEntity.status(HttpStatus.OK).body(personaDtos);
    }

}
