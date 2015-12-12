class Dog {

	private String name;

	public Dog(String name) {

		this.name = name;
	}

	public void bark() {

		System.out.println(String.format(" %s is barking ", name));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
public class Main {

	public Main() {

		Dog myDog; // 1
		myDog = new Dog("Karabas"); // 2
		myDog.bark();

		callAnyMethod(myDog); 
		myDog.bark();
	}

	public static void main(String[] args) {
		new Main();
	}

	public void callAnyMethod(Dog dog) { //4
		dog.setName("Comar"); // 5
		dog.bark();
		dog = new Dog("Badi"); // 6
		dog.bark();
		
		Dog c=dog;  //7
		c.bark();
	}
	
	//All the story is so simple.  Simply, JVM simply creates an object then give the address of it  to the references while calling methods it just the send of this address' 
	//and you can anything by this object in the address by using this copy address. 
	
	// 1-Dog is the blueprint(plan) here nothing else we called it "class"
	// 2-myDog is just a reference pointing the address of new Dog("Karabas"); is created in the memory and have an address lets say "303"  --> and JVM give this address to myDog.
	// 4-Just a reference pointing null  since there is no address in the memory yet.  pointing to null now. 
	// 3-THE KEY POINT HERE. JAVA WILL SEND TO THE METHOD JUST COPY OF THE ADDRESS OF THE DOG OBJECT IN THE MEMORY SO dog VARIBLE IN THE METHOD DECLARATION WILL POINT TO THE 
	//   SAME AS myDog POINTS. 
	// 5-we say simply go to the dog in this address and change of its name and tell it to bark.
	// 6-dog reference was just a copy of the myDog's reference. now tell the JVM create a new Dog and send me its memory address to me. and now dog is pointing new Dog named "Badi"
	// 7-A step further we say that copy the dog reference and give it to me and c says I will points to now where dog is pointing. 
	
	/* 	The results are as expected...
	 *  Karabas is barking 
 	  	Comar is barking 
 		Badi is barking 
 		Badi is barking 
 		Comar is barking*/
}
