 

import java.awt.Image;

public class Animal {
	Image picture;
	boolean whichFood;
	int hunger;
	double bondaries;
	String location;
	
	void makeNoise() {
		System.out.println("This is the makeNoise method from: Animal");
	}
	void eat() {
		System.out.println("This is the eat method from: Animal");
	}
	void sleep() {
		System.out.println("This is the sleep method from: Animal");

	}
	void roam() {
		System.out.println("This is the roam method from: Animal");
	}
}


class Feline extends Animal {
	
	void roam() {
		System.out.println("This is the roam method from: Feline");

	}
}

class Canine extends Animal {
	
	void roam() {	
		System.out.println("This is the roam method from: Canine");

	}
}
class Cat extends Feline {
	
	void makeNoise() {
		
	}
	void eat() {
		
	}
}
class Dog extends Canine {
	
	void makeNoise() {
		
	}
	void eat() {
		
	}
}
class Hippo extends Animal {
	
	void makeNoise() {
	}
	void eat() {
	}
}
class Lion extends Feline {
	
	void makeNoise() {
		
	}
	void eat() {
		
	}
}
class Tiger extends Feline {
	
	void makeNoise() {
		
	}
	void eat() {
		
	}
}
class Wolf extends Canine {

	void makeNoise() {
		System.out.println("This is the makeNoise method from: Wolf");
	}
	void eat() {
		System.out.println("This is the eat method from: Wolf");
	}
}



