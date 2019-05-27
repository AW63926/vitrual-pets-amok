package virtualPetShelter;

public class OrganicCat extends VirtualPet {
	

	public OrganicCat(String petName, String petType) {
		super(petName, petType);
		// TODO Auto-generated constructor stub
	}
	public OrganicCat(String petName) {
		super(petName, "Cat");
	}
	@Override
	public void valueChecker() {
		int hungerValue = getHungerLevel();
		if(hungerValue >= 10) {
			System.out.println(getPetName() + " needs to be fed right away!!!");
			decreaseHealthCounter();
		}
		int thirstValue = getThirstLevel();
		if(thirstValue >= 10) {
			System.out.println(getPetName() + " is in dire need of a drink!!");
			decreaseHealthCounter();
		}
		int boredomValue = getBoredomCount();
		if(boredomValue >= 10) {
			System.out.println(getPetName() + " needs some play time!  Toss " + getPetName() + " a ball of yarn!!");
			decreaseHealthCounter();
		}
		int excretionValue = getExcretionCount();
		if(excretionValue >= 10) {
			System.out.println(getPetName() + " has gone to the litter box.");
			bathroom(3);
			int afterExcretionCount = getExcretionCount();
			if(afterExcretionCount < 0) {
				setExcretionCounter(0);
			}
		}
		int healthValue = getHealthCount();
		if(healthValue <= 3) {
			System.out.println(getPetName() + " is not doing too well.  Check to see how you can help");
		}
		if(healthValue < 0) {
			setHealthCount(0);
			System.out.println(getPetName() + " must be taken to the vet immediately!!");
		}
	}

}
