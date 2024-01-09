package CrudMongoDocker.crud.repository;

import CrudMongoDocker.crud.document.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, UUID> {
}
