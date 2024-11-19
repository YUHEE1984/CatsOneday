package org.yuhee.catsoneday;

import java.util.ArrayList;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.yuhee.catsoneday.cat.BreedingSexException;
import org.yuhee.catsoneday.cat.Cat;

@SpringBootApplication
public class CatsonedayApplication {


	public static void main(String[] args) {
		SpringApplication.run(CatsonedayApplication.class, args);
	}


	public String getGreeting() {
        return " Hello Cats <3 ";
    }

	@Bean
	// Used to register a specific object as a bean by attaching it to an individual method of a configuration class
	// Establishing and automatically linking relationships between objects 'Beans' created and managed by 'Spring'
	// An annotation that we use to indicate that we want to register a method as a 'Bean'
	// another class receives @Autowired as a pass-through and uses it

	public ModelMapper getModelMapper() {
		return new ModelMapper();
		// Methods to help you automatically perform conversions between different objects
		// Easily create DTOs with only the fields you want
		//
	}
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		// After the application is started with the interface provided by Spring Boot (including the run method), it takes command line arguments and executes the code
		// Accept command line passes as an array of String[] args
		// Used to perform initial operations or settings when the application runs
		// Place a main class if you want to manage your application's entire initialization tasks in one place
		// Separate classes when you want to group settings that have many initializations or specific roles

		// ' ApplicationContext '  Perform operations to look up a specific bean or get the names of all beans
		// ' ApplicationContext ' Spring container that holds all managed beans and configuration information

		return args -> {

			Cat myCat01 = new Cat( null, "Mama", "F", "Egyptian Mau", 1, 1, "silver", "spotted", "gradints of grsy and deep green" );
			System.out.println(myCat01.toString());

			myCat01.setWeightInKg(1);
			System.out.println("Let me repeat cat name in case you forgot it. cat name is " +  myCat01.getName() +
						". And this is a little secret, but cat weight is " + myCat01.getWeightInKg() + " kg.");

			myCat01.lieDown();
			myCat01.groom();
			myCat01.loafing();
			myCat01.lookAround();
			myCat01.purr();
			myCat01.stretch();
			myCat01.pounce();
			myCat01.nuzzling();
			myCat01.meowing();
			myCat01.headButting();

			Cat myCat02 = new Cat( null, "Fafa", "M", "Egyptian Mau", 1, 1, "cream", "spotted", "gradints of gold and deep blue" );
			System.out.println(myCat02.toString());

			myCat02.setWeightInKg(1);
			System.out.println("Let me repeat cat name in case you forgot it. cat name is " +  myCat02.getName() +
						". And this is a little secret, but cat weight is " + myCat02.getWeightInKg() + " kg.");

			ArrayList<Cat> kittens;
			try {
				kittens = myCat01.breed(myCat02);
			} catch (BreedingSexException sexException) {
				System.err.println(sexException.getMessage());
					return;
			}

			String[] kittensName = new String[]{"Sava", "jam", "Dal", "Force", "Grog", "Cream"};
			
			for(Cat kitten : kittens) {
				
				Random random = new Random();
				String randomName = kittensName[random.nextInt(kittensName.length)];
				kitten.setName(randomName);
				System.out.println(kitten.toString());
			}
		};
	}

}
