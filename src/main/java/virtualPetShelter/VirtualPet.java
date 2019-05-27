package virtualPetShelter;

public class VirtualPet {
	private int hungerCounter;
	private int thirstCounter;
	private int boredomCount;
	
	private int excretionCounter;
	private int sleepyCounter;
	private String petName;
	private String petType;
	
	

	public VirtualPet(String petName, String petType) {
		this.petName = petName;
		this.petType = petType;
	}

	public int increaseHungerLevel(int hungerValue) {
		this.hungerCounter += hungerValue;
		return this.hungerCounter;
	}
	public void setHungerCounter(int hungerLevel) {
		this.hungerCounter = hungerLevel;
	}

	public int getHungerLevel() {
		// TODO Auto-generated method stub
		return this.hungerCounter;
	}

	public int increaseThirstValue(int thirstValue) {
		this.thirstCounter += thirstValue;
		return this.thirstCounter;
	}

	public int getThirstLevel() {
		return this.thirstCounter;
	}
	public void setThirstLevel(int thirstLevel) {
		this.thirstCounter = thirstLevel;
	}

	public void increaseBoredomCounter(int boredomValue) {
		this.boredomCount += boredomValue;

	}

	public int getBoredomCount() {
		return this.boredomCount;
	}
	public void setBoredomCounter(int boredomValue) {
		this.boredomCount = boredomValue;
	}

	

	

	public void increaseExcretionCounter(int excretionValue) {
		this.excretionCounter += excretionValue;

	}
	public void setExcretionCounter(int excreteValue) {
		this.excretionCounter = excreteValue;
	}

	public void eat(int hungerValue) {
		this.hungerCounter -= hungerValue;

	}

	public void drink(int thirstValue) {
		this.thirstCounter -= thirstValue;

	}

	public void bathroom(int excretionValue) {
		this.excretionCounter -= excretionValue;
	}

	public int getExcretionCount() {
		return this.excretionCounter;
	}

	public void play(int boredomValue) {
		this.boredomCount -= boredomValue;
	}

	

	public void givePetName(String petName) {
		this.petName = petName;

	}

	public String getPetName() {
		return this.petName;
	}

	public void assignPetType(String petType) {
		this.petType = petType;

	}

	public String getPetType() {
		return this.petType;
	}
	public void valueChecker() {
		int hungerValue = getHungerLevel();
		if(hungerValue >= 10) {
			System.out.println(getPetName() + " needs to be fed right away!!!");
		}
		int thirstValue = getThirstLevel();
		if(thirstValue >= 10) {
			System.out.println(getPetName() + " is in dire need of a drink!!");
		}
		int boredomValue = getBoredomCount();
		if(boredomValue >= 10) {
			System.out.println(getPetName() + " is bored to TEARS!!! " + getPetName() + " needs to play!!");
		}
		int excretionValue = getExcretionCount();
		if(excretionValue >= 10) {
			System.out.println(getPetName() + " has made a mess on the floor!!  Make sure to take the pets outside.");
		}
	}

	public int generateRandomNumber() {
		int random = (int) (Math.random() * 10);
		// System.out.println(random);
		return random;
	}
	public int generateRandBetweenZeroAndTwo() {
		int upper = 3;
		int lower = 0;
		int randNum = (int) (Math.random() * (upper - lower));
		//System.out.println(randNum);
		return randNum;
	}
	public void tick() {
		this.hungerCounter += generateRandBetweenZeroAndTwo();
		this.thirstCounter += generateRandBetweenZeroAndTwo();
		this.boredomCount += generateRandBetweenZeroAndTwo();
		this.excretionCounter += generateRandBetweenZeroAndTwo();
		
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
		
	}

	

	public void gamePlayVirtualPet() {
		setInitialValuesToRandom();
		
	}

	

}
