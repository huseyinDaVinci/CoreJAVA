public class AnimalOwner {

	String name;

	public AnimalOwner(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		// System.out.println(String.format("The %s's hash code:%s", name, "" +
		// hashCode()));
		return super.hashCode();

	}

	@Override
	public boolean equals(Object obj) {

		System.out.println(String.format("Before reaching a conclusion lets see the objects are the same:\n " + "The %s's hash code: %s  ---The object %s's hash code:%s", name,
				hashCode(), ((AnimalOwner) obj).name, ((AnimalOwner) obj).hashCode()));
		return super.equals(obj);

	}

}
