package org.yuhee.catsoneday.cat;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
// Tells Spring that this interface is a database access layer, and Spring automatically converts exception handling to database-specific exceptions

public interface CatRepository extends JpaRepository <Cat, Long> {
    // Basic interface to interact with the database (extends) Spring Data JPA via inheritance uses the CRUD methods implemented by default for Cat entities
    // <Cat, Long> where Cat refers to the entity class type and Long refers to the type of the primary key

    List<Cat> findByName(String name);
    // Custom query method to get a list of cats corresponding to the name property
    // Spring Data JPA interprets method names and automatically generates the appropriate SQL query, looking up Cat entities matching the name
    // Return multiple cats with the same name as a list
    // The role of queries is implemented through methods, and methods exist to perform tasks that interact with the database
}
