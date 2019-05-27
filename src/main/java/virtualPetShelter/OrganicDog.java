package virtualPetShelter;

public class OrganicDog extends VirtualPet{
	private int cageDirtinessCount;

	public OrganicDog(String petName, String petType) {
		super(petName, petType);
	}

	public OrganicDog(String petName) {
		super(petName, "Dog");
	}

	public int getCageDirtinessCount() {
		return cageDirtinessCount;
	}

	public void setCageDirtinessCount(int cageDirtinessValue) {
		this.cageDirtinessCount = cageDirtinessValue;
	}
	public void increaseCageDirtinessCount(int cageDirtinessValue) {
		this.cageDirtinessCount += cageDirtinessValue;
	}
	
	public void cleanCage() {
		setCageDirtinessCount(0);
		increaseHealthCounter();
	}
	public void setInitialValuesToRandom() {
		int boredom = generateRandomNumber();
		increaseBoredomCounter(boredom);
		int hunger = generateRandomNumber();
		increaseHungerLevel(hunger);
		int thirst = generateRandomNumber();
		increaseThirstValue(thirst);
		int excretionValue = generateRandomNumber();
		increaseExcretionCounter(excretionValue);
		int health = generateRandomNumber();
		initialDecreaseInHealth(health);
		int dirtiness = generateRandomNumber();
		setCageDirtinessCount(dirtiness);
		
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
			System.out.println(getPetName() + " is bored to TEARS!!! " + getPetName() + " needs to play!!");
			decreaseHealthCounter();
		}
		int excretionValue = getExcretionCount();
		if(excretionValue >= 10) {
			System.out.println(getPetName() + " has made a mess on the floor!!  Make sure to take the dogs outside.");
			increaseCageDirtinessCount(4);
			decreaseHealthCounter();
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
