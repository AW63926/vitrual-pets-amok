package virtualPetShelter;

public class OrganicDog extends VirtualPet{
	private int cageCleanlinessCout;

	public OrganicDog(String petName, String petType) {
		super(petName, petType);
	}

	public OrganicDog(String petName) {
		super(petName, "Dog");
	}

	public int getCageCleanlinessCout() {
		return cageCleanlinessCout;
	}

	public void setCageCleanlinessCout(int cageCleanlinessCout) {
		this.cageCleanlinessCout = cageCleanlinessCout;
	}
	

}
