/*
 * This source file was generated by the Gradle 'init' task
 */
package org.yuhee.catsoneday;

public class App {
    public String getGreeting() {
        return " Hello Cats <3 ";
    }

    public static void main(String[] args) {


        System.out.println(new App().getGreeting());

	
	Cat myCat = new Cat( "Kitty", "F", "Egyptian Mau", 1, 1, "silver", "spotted", "gradints of grsy and gold" );

	System.out.println(myCat.toString());
	
	myCat.lieDown();
	myCat.groom();
	myCat.loafing();
	myCat.lookAround();
	myCat.purr();
	myCat.stretch();
	myCat.pounce();
	myCat.nuzzling();
	myCat.meowing();
	myCat.headButting();

    }
}