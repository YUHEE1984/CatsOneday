
package org.yuhee.catsoneday;


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter


public class Cat {


	private static final Random RANDOM = new Random();	

	@Setter
	private String name;
	private String sex;
	private String breeds;
	private int age;
	@Setter
	private int weightInKg;
	private String furColor;
	private String furPattern;
	private String eyeColor;

	
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


	public String toString() {
	
		return "My cat is " + this.name + ". " +
			this.name + " is a " + this.breeds + " cat with " + 
			this.furColor + " fur and " + this.furPattern + " pattern and " + this.eyeColor + " eyes. " +
			this.name + " is a " + this.sex + ". ";
	}

	
	public ArrayList<Cat> breed(Cat parentsCat) {
		return parentsCat.handleBreeding( 
			this.breeds + "," + parentsCat.breeds,
			this.furColor +  "," + parentsCat.furColor,
			this.furPattern +  "," + parentsCat.furPattern,
			this.eyeColor +  "," + parentsCat.eyeColor
		);
	}

        private String getRandomElementByShuffling(String options) {

                if (options == null || options.isEmpty()) {
                        throw new IllegalArgumentException( " Option cannot be null or empty " );
                }

                ArrayList<String> optionList = new ArrayList<>();
                Collections.addAll( optionList, options.split( "," ) );

                Collections.shuffle( optionList, RANDOM );
                return optionList.get(0);
        }

	private ArrayList<Cat> handleBreeding(String breeds, String furColor, String furPattern, String eyeColor) {
		
		ArrayList<Cat> kittens = new ArrayList<Cat>();

		int min = 2;
		int numberOfKittens = RANDOM.nextInt( 4 ) + min;


		for (int i = 0; i < numberOfKittens; i++) {
			int kittenWeightInKg = RANDOM.nextInt( 3 ) + 3; 
			String kittenSex = RANDOM.nextInt( 2 ) == 0 ? "F" : "M";
			String kittenBreeds = getRandomElementByShuffling( breeds );
			String kittenFurColor = getRandomElementByShuffling( furColor );
        		String kittenFurPattern = getRandomElementByShuffling( furPattern );
        		String kittenEyeColor = getRandomElementByShuffling( eyeColor );
			
			Cat kitten = new Cat("", kittenSex, kittenBreeds, 0, kittenWeightInKg, kittenFurColor, kittenFurPattern, kittenEyeColor );
			kittens.add(kitten);

		}
		return kittens;
	}


}
