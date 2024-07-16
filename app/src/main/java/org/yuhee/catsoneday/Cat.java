class Cat {


	String name;
	String sex;
	String breeds;
	int age;
	int weightInKg;
	String furColor;
	String furPattern;
	String eyeColor;


	public Cat (String name, String sex, String breeds, int age, int weightInKg, String furColor, String furPattern, String eyeColor) {
	
		this.name = name;
		this.sex = sex;
		this.breeds = breeds;
		this.age = age;
		this.weightInKg = weightInKg;
		this.furColor = furColor;
		this.furPattern = furPattern;
		this.eyeColor = eyeColor;

	} 
		
	
	public void eatCatFood() {
                System.out.println( " The cat is eating kibble or snack " ) 
	}

	public void eatChurr() {
		System.out.println( " The cat is licking Churu " ) 
	}

	public void drink() {
                System.out.println( " The cat is drinking water or fat milk " ) 
        }	


	public void sleep() {
                System.out.println( " The cat is sleeping " ) 
        }

        public void yawn() {
                System.out.println( " The cat is yawning lazily " )
        }

        public void dozing() {
                System.out.println( " The cat is dozing " )
        }
	
        public void loafing() {
                System.out.println( " The cat is loafing " )
        }

	public void lounge() {
                System.out.println( " The cat is lounging " )
        }

        public void kneading() {
                System.out.println( " The cat is kneading " )
        }

	public void stretch() {
                System.out.println( " The cat is stretching its body " )
        }

        public void groom() {
                System.out.println( " The cat is grooming " )
        }


        public void lieDown() {
                System.out.println( " The cat is curling up " )
        }

	public void sit() {
                System.out.println( " The cat is sitting " )
        }

	public void walk() {
                System.out.println( " The cat is walking " )
        }

        public void run() {
                System.out.println( " The cat is running " )
        }

        public void pounce() {
                System.out.println( " The cat is pouncing on a something " )
        }

        public void hide() {
                System.out.println( " The cat is hiding " )
        }

        public void catch() {
                System.out.println( " The cat caught something " )
        }

        public void punch() {
                System.out.println( " The cat is pawing at the something" )
        }

        public void playWithToy() {
                System.out.println( " The cat is playing with toy " )
        }

        public void lookAround() {
                System.out.println( " The cat is gazing " )
        }

	public void wagTail() {
        	System.out.println("The cat is wagging its tail.");

	}


        public void purr() {
                System.out.println( " The cat is purring contentedly " )
        }

        public void meowing() {
                System.out.println( " The cat is meowing " )
        }

        public void nuzzling() {
                System.out.println( " The cat is nuzzling me " )
        }

        public void headButting() {
                System.out.println( " The cat is head-butting me " )
        }


	public String toString() {
	
		return "My cat is " + this.name + ". " +
			this.name + " is a " + this.breeds + " cat with " + 
			this.furColor + " fur and " + this.furPattern " pattern and " + this.eyeColor + " eyes. " +
			this.name + " is a " + this.sex + ". ";
	}
