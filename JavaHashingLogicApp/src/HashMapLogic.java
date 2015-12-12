import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapLogic {

	private HashMap<AnimalOwner, Animal> animalOwerPairs = new HashMap<AnimalOwner, Animal>();

	public HashMapLogic() {

		// We assume that there would be two owners. If we agree lets do some
		// business

		AnimalOwner owner1 = new AnimalOwner("sam");
		System.out.println(String.format("HashCode of %s is %s", owner1.name, owner1.hashCode()));
		AnimalOwner owner2 = new AnimalOwner("sam");
		System.out.println(String.format("HashCode of %s is %s", owner2.name, owner1.hashCode()));

		Animal animal1 = new Animal("tom");

		animalOwerPairs.put(owner1, animal1);
		animalOwerPairs.put(new AnimalOwner("sam"), animal1);
		animalOwerPairs.put(owner2, animal1);

		// Lets understand how Hash Map is working calls an iterator

		Iterator<Entry<AnimalOwner, Animal>> it = animalOwerPairs.entrySet().iterator();

		while (it.hasNext()) {

			Map.Entry mapEntry = it.next();

			System.out.println(String.format("Map.Entry object java Hash Map used:\n key:%s and value %s", mapEntry.getKey(), mapEntry.getValue()));

		}

		// We add three owner with the same name and according to rule above
		// this would not be possible
		// However, it is not true we will add 3 fucking owners with the same
		// name to the map. (If we override hashCode() and equals() method then
		// apply comparision we want later OK:)))
		for (AnimalOwner owner : animalOwerPairs.keySet()) {
			System.out.println("Animal Owner:" + owner.getName() + "\tAnimal who cares:" + animalOwerPairs.get(owner).name);
		}

	}

	public static void main(String[] args) {

		new HashMapLogic();

	}

}
