package org.yuhee.catsoneday.cat;

import org.yuhee.catsoneday.CatNotFoundException;
import org.yuhee.catsoneday.dto.CatDetailDto;
import org.yuhee.catsoneday.dto.CatInListDto;
import org.yuhee.catsoneday.dto.CreateCatDto;

import java.util.List;

public interface CatService {

    CatDetailDto addCat(CreateCatDto cat);
    // Adding new cat information to the database ( Dto with information needed when adding a new cat )
    // Returns the added cat information
    List<CatInListDto> find(String name);
    // Search by name to get a list of cats with that name
    // An object list that contains brief information about the cat, with only the information needed to look it up in the list.
    CatDetailDto findOne(long id) throws CatNotFoundException;
    // Pass and retrieve details of cats with a specific ID by unique identifier
    // object to provide details about that cat.


    // Use Dto objects to separate the roles between database entities and objects sent to the client, acting as an interface for transport and transformation
    // Only the information the client needs is presented in the right form, and the logic of interacting with the database is simplified

}
