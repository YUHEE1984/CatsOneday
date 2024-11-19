package org.yuhee.catsoneday.cat;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.yuhee.catsoneday.CatNotFoundException;
import org.yuhee.catsoneday.dto.CatDetailDto;
import org.yuhee.catsoneday.dto.CatInListDto;
import org.yuhee.catsoneday.dto.CreateCatDto;
import java.util.List;
import java.util.Optional;


@Service
// An annotation in the Spring framework that specifies that it is a service class
// The layer responsible for the business logic of an application, typically processing data, making calculations, applying business rules, etc
// Managed as a Spring container bean, which can be injected from other classes
// No direct access to the database, instead accessing it indirectly through the Repository layer to process the necessary business logic
@AllArgsConstructor
// Automatically create a constructor that takes all fields of that class as parameters and initializes them


public class CatServiceImpl implements CatService {


    CatRepository catRepository; // A place to store CatRepository implementation objects
    ModelMapper modelMapper; // A place to store ModelMapper for transformations between models and DTOs


    @Override
    public CatDetailDto addCat(CreateCatDto cat) {

        Cat catModel = modelMapper.map(cat, Cat.class);
        // A library that automatically performs mappings between DTOs and entities, simplifying object conversions in code
        // Convert an object of type CreateCatDto to a Cat entity object(Contains an identifier (ID))
        return modelMapper.map(catRepository.save(catModel), CatDetailDto.class);
        // Converting entity objects in the database to a format that's good for responding to clients(Save the converted Cat entity(catModel) object to the database, Convert a stored Cat object back to the CatDetailDto type)
        // Finally, a CatDetailDto object is returned (containing only the information the client needs to determine the cat information)

    }
    // Don't forget import new class


    @Override
    public List<CatInListDto> find(String name) {

        List<Cat> retrievedCats; // Storage for retrieved Cat list data

        if(name == null) {
            retrievedCats = catRepository.findAll(); // Lookup all Cat objects
        } else {
            retrievedCats = catRepository.findByName(name); // Lookup Cat objects with a specific name
        }

        return retrievedCats.stream()
                // Make data sources(List<Cat>) processable through the Stream API (filter, transform, sort, aggregate, etc.)
                .map(catModel -> modelMapper.map(catModel, CatInListDto.class))
                // Map each Cat object to CatInListDto (data type conversion) with 'map'
                .toList(); // Collect and return converted objects as a list

    } // Retrieves a list of Cat objects, converts each object to a CatInListDto and returns it


    @Override
    public CatDetailDto findOne(long id) throws CatNotFoundException {

        Optional<Cat> result = catRepository.findById(id);
        // Lookup a given cat (id) in the database, returning it as an Optional type (to safely handle situations with or without results)
        if (result.isPresent()) {
            return modelMapper.map(result.get(), CatDetailDto.class);
            // Check if the Optional object has a value, if it does, get it with 'result.get()'
            // Convert the retrieved Cat object to 'CatDetailDto', containing only the information needed for the API response
        } else {
            throw new CatNotFoundException(id);
            // Instead of returning 'null' when 'false', throw a new 'CatNotFoundException' with the ID in it
        }

    }


}