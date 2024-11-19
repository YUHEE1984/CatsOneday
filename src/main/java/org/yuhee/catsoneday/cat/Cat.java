
package org.yuhee.catsoneday.cat;
// MVC Model


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.*;
import lombok.NoArgsConstructor;


@AllArgsConstructor
// Automatically generate a constructor that has every attribute of the class as a parameter.
// and assigns the parameter values to those class attributes.
@Entity
// Used when mapping that class to a database table, treating the class as an object (entity) that can be stored in the database
// JPA recognizes the class as a database table, and the fields in the class (@Id, etc ) correspond to columns in the database table
@NoArgsConstructor
// Provided by the Lombok library, which automatically generates default constructors with no parameters
// Allows frameworks like JPA to create instance objects without explicitly writing constructors
@Data
// Automatically generate commonly used methods for a class, powered by Lombok
// getter, setter, toString, equals, hashCode, default constructor, etc.


public class Cat {


	private static final Random RANDOM = new Random();
    // Create an instance of the 'Random' class above for the Cat production's random selection feature


    @Id
    // An annotation that specifies a unique identifier for a JPA entity, allowing you to manage records in the database by making that field the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    // specify the primary key to be generated automatically(Attributes that specify the primary key generation strategy = JPA to automatically generate identities in a database-specific way(AUTO))
    // Used when JPA automatically generates the primary key for an entity, used with @Id to set the primary key to be assigned automatically
    private Long id;
    // long base(primitive) type defaults to 0.0 and cannot have a null value
    // Using the Long(Object) type to allow for nulls when the object is initially created with no ID


	private String name;
	private String sex;
	private String breeds;
	private int age;
	private int weightInKg;
	private String furColor;
	private String furPattern;
	private String eyeColor;
    // Define a bunch of attributes for cat.


	public void eatCatFood() {
                System.out.println( " The cat is eating kibble or snack " ); 
	}

	public void eatChurr() {
		System.out.println( " The cat is licking Churu " );
	}

	public void drink() {
                System.out.println( " The cat is drinking water or fat milk " ); 
        }	


	public void sleep() {
                System.out.println( " The cat is sleeping " );
        }

        public void yawn() {
                System.out.println( " The cat is yawning lazily " );
        }

        public void dozing() {
                System.out.println( " The cat is dozing " );
        }
	
        public void loafing() {
                System.out.println( " The cat is loafing " );
        }

	public void lounge() {
                System.out.println( " The cat is lounging " );
        }

        public void kneading() {
                System.out.println( " The cat is kneading " );
        }

	public void stretch() {
                System.out.println( " The cat is stretching its body " );
        }

        public void groom() {
                System.out.println( " The cat is grooming " );
        }


        public void lieDown() {
                System.out.println( " The cat is curling up " );
        }

	public void sit() {
                System.out.println( " The cat is sitting " );
        }

	public void walk() {
                System.out.println( " The cat is walking " );
        }

        public void run() {
                System.out.println( " The cat is running " );
        }

        public void pounce() {
                System.out.println( " The cat is pouncing on a something " );
        }

        public void hide() {
                System.out.println( " The cat is hiding " );
        }

        public void capture() {
                System.out.println( " The cat caught something " );
        }

        public void punch() {
                System.out.println( " The cat is pawing at the something" );
        }

        public void playWithToy() {
                System.out.println( " The cat is playing with toy " );
        }

        public void lookAround() {
                System.out.println( " The cat is gazing " );
        }

	public void wagTail() {
        	System.out.println("The cat is wagging its tail.");

	}

        public void purr() {
                System.out.println( " The cat is purring contentedly " );
        }

        public void meowing() {
                System.out.println( " The cat is meowing " );
        }

        public void nuzzling() {
                System.out.println( " The cat is nuzzling me " );
        }

        public void headButting() {
                System.out.println( " The cat is head-butting me " );
        }
    // Define some public methods for actions a cat does.


	public String toString() {
	
		return "My cat is " + this.name + ". " +
			this.name + " is a " + this.breeds + " cat with " + 
			this.furColor + " fur and " + this.furPattern + " pattern and " + this.eyeColor + " eyes. " +
			this.name + " is a " + this.sex + ". ";
	}
    // Define method to describe the attributes of cat


	public ArrayList<Cat> breed(Cat parentsCat) throws BreedingSexException {
        // Set list as the return type to hold the object of kittens returned from handleBreeding
        // Declare 'Cat' type parameter 'parentsCat' because we need two cat properties for breeding
        // Use 'throws' to specify the exception 'BreedingSexException' that can be thrown by the method


        if (this.sex.equals(parentsCat.sex)) {
            throw new BreedingSexException(this, parentsCat);
            // Set an exception (Check the parent cats are the same gender with 'equals')
        }

        return parentsCat.handleBreeding(
			this.breeds + "," + parentsCat.breeds,
			this.furColor +  "," + parentsCat.furColor,
			this.furPattern +  "," + parentsCat.furPattern,
			this.eyeColor +  "," + parentsCat.eyeColor

		);  // Take the properties of the two cat variables in this method and pass them as parameter values to the 'handleBreeding' method
            // Take the return value 'kittens' from the 'handleBreeding' method and use it as the return data value for this method, then exit
	}

        private String getRandomElementByShuffling(String options) {
        // Cat property data of string type is passed in the parameter 'option' and used by this method


                if (options == null || options.isEmpty()) {
                        throw new IllegalArgumentException( " Option cannot be null or empty " );
                } //  Declare an exception that the method will not work if the data passed to 'option' has no value


                ArrayList<String> optionList = new ArrayList<>();
                Collections.addAll( optionList, options.split( "," ) );
                // Store the data values passed to 'options', separated by ' , ', in an 'ArrayList' type variable 'optionList'
                // Import required to use 'addAll' method of 'Collections' class


                Collections.shuffle( optionList, RANDOM );
                // To randomly shuffle the order of the data in the 'optionList', use the 'shuffle' method of the 'Collections' class
                // Using the instance object variable 'RANDOM' of class 'Random' together to fix random behavior as needed

                return optionList.get(0);
                // 'get' method to return the final(first data) stored data in the variable 'optionList'
        }


	private ArrayList<Cat> handleBreeding(String breeds, String furColor, String furPattern, String eyeColor) {
        // A cat property parameter line that receives the properties of both cats in the 'Breed' method.


		ArrayList<Cat> kittens = new ArrayList<Cat>();
        // Declare a array variable 'kittens' to hold the results of the kittens randomly generated by the 'for' statement below


		int min = 2;
		int numberOfKittens = RANDOM.nextInt( 4 ) + min;
        // The variable 'numberOfKittens' line, which stores the value of the random method for determining how many kittens to produce
        // The value of the variable that determines how many times the 'for' statement below is repeated
        // Set a random number of kittens from a minimum of 2 to a maximum of 5 (2 + 3)


		for (int i = 0; i < numberOfKittens; i++) {

			int kittenWeightInKg = RANDOM.nextInt( 3 ) + 3;
            // Set the cat's weight to the default value of 3 kg, then randomly generate three numbers from 0 to 2 and add them together to get a value
			String kittenSex = RANDOM.nextInt( 2 ) == 0 ? "F" : "M";
            // In the same way, randomly generate a 0 or 1 number, and if the result is equal to 0, set 'F' or 'M'
			String kittenBreeds = getRandomElementByShuffling( breeds );
			String kittenFurColor = getRandomElementByShuffling( furColor );
        		String kittenFurPattern = getRandomElementByShuffling( furPattern );
        		String kittenEyeColor = getRandomElementByShuffling( eyeColor );
                // Pass each property value to the 'optionList' in 'getRandomElementByShuffling' to get the result
			
			Cat kitten = new Cat(null,"", kittenSex, kittenBreeds, 0, kittenWeightInKg, kittenFurColor, kittenFurPattern, kittenEyeColor );
            // Each iteration of the function generates a single cat 'kitten' with random properties
			kittens.add(kitten);
            // Add and store the variable 'kitten' with the new kittens data in the variable 'kittens' of type 'ArrayList<Cat>'

		}
		return kittens;
        // This result value data is passed to the 'parentsCat.handleBreeding' return value of the 'breed' method
	}


}
