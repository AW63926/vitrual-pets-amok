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
		if(boredomValue >= 10) {
			System.out.println(getPetName() + " is eager to show off!!  Give " + getPetName() + " some attention.");
			decreaseHealthCounter();
		}
		
		int healthValue = getHealthCount();
		if(healthValue <= 3) {
			System.out.println(getPetName() + " is looking a little rusty");
		}
		if(healthValue < 0) {
			setHealthCount(0);
			System.out.println(getPetName() + " has ceased up and needs immediate attention!");
		}
	}
	


}
