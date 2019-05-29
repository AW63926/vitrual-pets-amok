package virtualPetShelter;

public class RoboPet extends VirtualPet{
	private int oilLevel = 0;

	public RoboPet(String petName, String petType) {
		super(petName, petType);
	}
	
	public RoboPet(String petName) {
		super(petName, "Robot");
	}
	
	public int getOilLevel() {
		return oilLevel;
	}
	
	public void setOilLevel(int oilLevel) {
		this.oilLevel = oilLevel;
	}
	
	public void changeOil() {
		this.oilLevel = 10;
	}
	public void increaseOilLevel(int oilLevel) {
		this.oilLevel += oilLevel;
	}
	
	public void decreaseOilLevel(int oilLevel) {
		this.oilLevel -= oilLevel;
	}
	
	public void roboTick() {
		int random = (int)(Math.random() * 5);
		decreaseOilLevel(random);
		increaseBoredomCounter(3);
	}
	
	
	@Override
	public void setInitialValuesToRandom() {
		int boredom = generateRandomNumber();
		increaseBoredomCounter(boredom);
		setOilLevel(10);
		setHealthCount(15);
		
		
	}
	
	@Override
	public void valueChecker() {
		
		int boredomValue = getBoredomCount();
		if(boredomValue >= 7 && boredomValue < 10) {
			System.out.println(getPetName() + " is eager to show off!!  Give " + getPetName() + " some attention.");
		}
		if(boredomValue >= 10) {
			System.out.println(getPetName() + " is extremely bored, and has begun plotting a mutiny!!");
			
		}
		
		if(oilLevel < 3) {
			System.out.println(getPetName() + " is running a little rough and needs an oil change!");
		}
		if(oilLevel < 0) {
			System.out.println(getPetName() + " is ceasing up and needs an oil change immediately!!");
			setOilLevel(0);
		}
	}

	


}
