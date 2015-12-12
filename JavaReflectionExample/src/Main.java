import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {

	public Main() {

		reflectionTest1(); // getting dynamically methods from java.lang.reflect
							// package.

		reflectionTest2(); // creating an object from Class instance dynamically at the runtime

		
		reflectionTest3();   //get constructor and create instance
		
		
		
	}

	private void reflectionTest3() {
		
		
		Class<?> c=null;
		
		
		try {
			
			c=Class.forName("Animal");
			
			
			Constructor<?> constructors[]=c.getConstructors();
			
			
			Animal a1=(Animal) constructors[0].newInstance();
			Animal a2=(Animal) constructors[1].newInstance("Karabas");
		
		
			if(a1!=null && a2!=null){
				
				a1.print();
				a2.print();
			}
		
		} catch (Exception e) {
			
		}
		
		
		
		
	}

	private void reflectionTest2() {

		Class<?> c = null;

		try {

			c = Class.forName("Animal");

			Animal a = (Animal) c.newInstance();
			
			
			

			a.print();
		} catch (Exception e) {

		}

	}

	private void reflectionTest1() {
		Animal animal = new Animal();

		Method method;

		try {

			for (Method m : animal.getClass().getMethods()) {

				System.out.println("Method:" + m.getName());

				if (m.getName().equalsIgnoreCase("print")) {

					m.invoke(animal);
				}

			}

		} catch (Exception e) {

			System.out.println("Error:" + e.getMessage().toString());
		}
	}

	public static void main(String[] args) {

		new Main();

	}

}

class Animal implements Serializable{

	
	String animalName="";
	public Animal(){
		
		
	}
	
	public Animal(String name){
		
		animalName=name;
		
	}
	
	
	public void print() {

		System.out
				.println("Animal Name:" + animalName);
	}

}
