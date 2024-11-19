package org.yuhee.catsoneday.cat;
//  MVC Controller


import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import org.yuhee.catsoneday.CatNotFoundException;
import org.yuhee.catsoneday.dto.CatDetailDto;
import org.yuhee.catsoneday.dto.CatInListDto;
import org.yuhee.catsoneday.dto.CreateCatDto;

import java.util.List;


@AllArgsConstructor
// Setting up constructor-based dependency injection
// Spring finds 'CatServiceImpl' and injects it into this variable
@RestController
// Setting up the controller class as a RESTful web service
// Combining @Controller and @ResponseBody(Return data as an HTTP response)
// Automatically convert a method's return value to JSON or XML format
@RequestMapping("/cats")
// Map a URL path to a class or method
// Supports all HTTP methods like GET, POST, PUT, and DELETE
// Specifying a common URL path with a declaration at the class level


public class CatController {

    @Autowired
            // Spring finds a bean of type 'CatService' and automatically assigns it to this field
            // Rather than creating the object directly, we let the Spring container use the one it manages
            // Clarify dependency connections in your application's hierarchy (Controller → Service → Repository)
    CatService catService;
    // A service class registered with the @Service annotation.
    // Handles business logic, called by another class (controller)

    @GetMapping("/{id}")
    // Mapping an HTTP GET request to a specific method, a GET request-only shorthand for @RequestMapping
    // @RequestMapping(method = RequestMethod.GET) > /cats/{id}
    // Specify a path in the form @GetMapping(“/path”)
    // This tells Spring to call this method on request with '/cats/{id(variable)}'
    public CatDetailDto getOne(@PathVariable Long id) {
        // Methods for getting a one cat(Return Value)
        // '@PathVariable' tells Spring that the 'id' parameter here corresponds to 'Mapping {id}'
        // 'Inline' means the annotation and parameter are written on the same line

        CatDetailDto cat;
        // Space to store searched cats (variable)

        try {
            cat = catService.findOne(id);
        } catch (CatNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            // If no cats match the ID, a 'CatNotFoundException' exception is thrown
            // Setting the HTTP response status to '404 NOT FOUND' using 'ResponseStatusException'
            // Tells the client that “the requested resource was not found”
        }
        return cat;
    } // Call the 'findOne() method(variable: id)' of the 'catService' object and save the output in the 'cat(CatDetailDto)'

    @PostMapping
    // Mapping to a specific URL by attaching it to a method for handling HTTP POST requests
    // Usually handles data contained in the Request Body
    public CatDetailDto createCat(@RequestBody CreateCatDto cat) {
        // '@RequestBody' maps the request body to a Java object
        // Spring converts the JSON data into a 'CreateCatDto' object
        return catService.addCat(cat);
        // Saving a new cat to the database with the 'addCat' method
        // Convert the details to a 'CatDetailDto' object to respond to the client

    } // API endpoints that generate new cat data

    @GetMapping
    // Mapping to handle 'HTTP GET' requests
    // This method connects to the '/cats' endpoint
    public List<CatInListDto> get(@RequestParam(required = false) String name) {
        // @RequestParam_Maps Query Parameters in HTTP requests (consisting of keys and values with optional information added at the end of the URL) to parameters in controller methods
        // Clients can send the 'name' query parameter
        // required = false_no error is thrown even if no query parameter is present (name = null)
        return catService.find(name);
        //retrieving(catService. find()) cat data based on the passed in name value and return the list of cat
    }

}
