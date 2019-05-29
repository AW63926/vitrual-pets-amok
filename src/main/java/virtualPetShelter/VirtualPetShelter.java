package virtualPetShelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelter {
	Scanner input = new Scanner(System.in);
	Map<String, VirtualPet> pets = new HashMap<>();
	Map<String, RoboPet> robopets = new HashMap<>();
	int welcomeCount = 0;
	int litterBoxCounter = 0;

	public void addVirtualPet(VirtualPet petObject) {
		pets.put(petObject.getPetName(), petObject);

	}

	public void addRoboPet(RoboPet roboObject) {
		robopets.put(roboObject.getPetName(), roboObject);
	}

	public VirtualPet findVirtualPet(String petName) {
		return pets.get(petName);
	}

	public RoboPet findRoboPet(String roboName) {
		return (RoboPet) robopets.get(roboName);
	}

	public OrganicDog findOrganicDog(String dogName) {
		return (OrganicDog) pets.get(dogName);
	}

	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}

	public void removeAVirtualPet(VirtualPet petName) {
		pets.remove(petName.getPetName(), petName);

	}
	public void removeARoboPet(RoboPet petName) {
		robopets.remove(petName.getPetName(), petName);
	}

	public int getLitterBoxCount() {
		return this.litterBoxCounter;
	}

	public void increaseLitterBoxCOunter(int litterBoxCount) {
		this.litterBoxCounter += litterBoxCount;
	}

	public void decreaseLitterBoxCounter(int litterBoxValue) {
		this.litterBoxCounter -= litterBoxValue;
	}

	public void litterBoxAdditionPerNewCat() {
		int random = (int) (Math.random() * 5);
		this.litterBoxCounter += random;

	}

	public void litterBoxChecker() {
		int litterBox = getLitterBoxCount();
		if (litterBox >= 10) {
			System.out.println("Please Clean the litter Box.  Its disgusting in there!");
		}
	}

	public void welcome() {
		System.out.println("Hello, Welcome to Adam\'s Pet Palace!");
		System.out.println("How can we help you?");
	}

	public void gamePlay() {
		menuItems();
		shelterSwitchStatement();
	}

	public void menuItems() {
		if (welcomeCount == 0) {
			welcome();
			welcomeCount++;
		}
		System.out.println("1.  Enter 1 to feed the pets?");
		System.out.println("2.  Enter 2 to give the pets a drink?");
		System.out.println("3.  Enter 3 to play with a pet?");
		System.out.println("4.  Enter 4 to Adopt a pet?");
		System.out.println("5.  Enter 5 to admit a pet?");
		System.out.println("6.  Enter 6 to take a pet on a bathroom break.");
		System.out.println("7.  Enter 7 to clean up after the pets.");
		System.out.println("8.  Enter 8 to check on all of the pets.");
		System.out.println("9.  Enter 9 to display the menu.");
		System.out.println("10. Enter \"Quit\" to exit.");
	}

	public void shelterSwitchStatement() {
		boolean switchLoop = true;
		while (switchLoop) {

			String switchValue = input.next();
			switch (switchValue.toLowerCase()) {
			case "1":
				// this will be where the eat method is called on all pets in the collection
				System.out.println("The pets are all being fed");
				for (String key : pets.keySet()) {
					VirtualPet keyPet = findVirtualPet(key);
					keyPet.eat(4);
					keyPet.increaseHealthCounter();
					if (keyPet.getHungerLevel() < 0) {
						keyPet.setHungerCounter(0);
					}
				}
				break;
			case "2":
				// this will be where the drink method is called on all pets in the collection
				System.out.println("The pets are all getting a drink");
				for (String key : pets.keySet()) {
					VirtualPet keyPet = findVirtualPet(key);
					keyPet.drink(3);
					keyPet.increaseHealthCounter();
					if (keyPet.getThirstLevel() < 0) {
						keyPet.setThirstLevel(0);
					}
				}
				break;
			case "3":
				System.out.println("Would you like to play with a Robot or Animal Pet?");
				System.out.println("Enter 1 for animal.");
				System.out.println("Enter 2 for robot.");
				String typeChoice = input.next();
				switch(typeChoice) {
				case "1":
					System.out.println("Which pet would you like to play with?");
					for (String key : pets.keySet()) {
						System.out.println(key);
					}
					String petString = input.next();
					VirtualPet myPet = findVirtualPet(petString);
					myPet.play(5);
					if (myPet.getBoredomCount() < 0) {
						myPet.setBoredomCounter(0);
					}
					System.out.println(myPet.getPetName() + " is having fun, and Boredom has been reduced to "
							+ myPet.getBoredomCount());
					myPet.increaseHealthCounter();
					break;
				case "2":
					System.out.println("Which RoboPet would you like to play with?");
					for (String roboKey : robopets.keySet()) {
						System.out.println(roboKey);
					}
					String roboPetName = input.next();
					RoboPet playPet = findRoboPet(roboPetName);
					playPet.play(3);
					if(playPet.getBoredomCount() < 0) {
						playPet.setBoredomCounter(0);
					}
					System.out.println(playPet.getPetName() + " is having a blast!");
					break;
					default:
						System.out.println("Please choose a robot or animal pet to play with.");
						System.out.println("Its not like you have anything better to do....");
						break;
				}
				break;
			case "4":
				System.out.println("Would you like to adopt an Animal pet or a RoboPet?");
				System.out.println("Enter 1 for Animal Pet.");
				System.out.println("Enter 2 for RoboPet.");
				String oneOrTwo = input.next();
				switch (oneOrTwo) {
				case "1":
					System.out.println("Which pet would you like to adopt?");
					for (String key : pets.keySet()) {
						System.out.println(key);
					}
					if (pets.isEmpty()) {
						System.out.println("Sorry, there are no pets in the shelter to adopt.");
						break;
					}
					String userChoice = input.next();
					VirtualPet userPet = findVirtualPet(userChoice);
					removeAVirtualPet(userPet);
					System.out.println("Thanks for adopting " + userChoice + "!!");
					break;
				case "2":
					System.out.println("Which RoboPet would you like to adopt?");
					for (String key : robopets.keySet()) {
						System.out.println(key);
					}
					if (robopets.isEmpty()) {
						System.out.println("Sorry, there are no RoboPets available for adoption today.");
						break;
					}
					String userSelection = input.next();
					RoboPet userRoboPet = findRoboPet(userSelection);
					removeARoboPet(userRoboPet);
					System.out.println("Thanks for adopting " + userSelection + "!!");
					break;
					
				}
				break;
			case "5":
				// Add a pet to shelter
				System.out.println("What is the name of the pet?");
				String petName = input.next();
				System.out.println("What kind of pet will be joining us here?");
				System.out.println("Enter 1 for Dog.");
				System.out.println("Enter 2 for Cat.");
				System.out.println("Enter 3 for RoboPet.");
				System.out.println("Enter 4 for Other Pets.");
				String petType = input.next();
				switch (petType) {
				case "1":
					OrganicDog petObject = new OrganicDog(petName);
					addVirtualPet(petObject);
					petObject.setInitialValuesToRandom();
					System.out.println("We will take good care of this dog and see that a home is found.");
					break;
				case "2":
					OrganicCat catObject = new OrganicCat(petName);
					addVirtualPet(catObject);
					catObject.setInitialValuesToRandom();
					System.out.println("We will take good care of this cat until a great home is found.");
					litterBoxAdditionPerNewCat();
					litterBoxChecker();
					break;
				case "3":
					RoboPet roboPetObject = new RoboPet(petName);
					addRoboPet(roboPetObject);
					roboPetObject.setInitialValuesToRandom();
					System.out.println("RoboPets are always welcome here!  Thank You.");
					break;
				case "4":
					// add other pet from VirtualPet class
					System.out.println("Please enter the Specific type of pet.");
					petType = input.next();
					VirtualPet anyPet = new VirtualPet(petName, petType);
					System.out.println("Thank You.  We will take good care of this " + petType + ".");
					addVirtualPet(anyPet);
					break;
				}

				break;
			case "6":
				// take a pet on a bathroom break
				System.out.println("Which pet are you taking on a Bathroom break?");
				for (String key : pets.keySet()) {
					System.out.println(key);
				}
				String petBathroomName = input.next();
				VirtualPet petBathroom = findVirtualPet(petBathroomName);
				if(petBathroom.getPetType() == "Cat") {
					System.out.println(petBathroomName + " is a cat, and will use the litter box when ready.  ");
					break;
				}
				petBathroom.bathroom(3);
				petBathroom.increaseHealthCounter();
				if (petBathroom.getExcretionCount() < 0) {
					petBathroom.setExcretionCounter(0);
				}
				System.out.println(petBathroom.getPetName() + " has gone to the bathroom and Bathroom Level is now "
						+ petBathroom.getExcretionCount());
				break;
			case "7":
				// this will clean up after the pets
				System.out.println("Would you like to clean a Dog Cage or the Litter Box?");
				System.out.println("Press 1 for Dog Cage.");
				System.out.println("Press 2 for Litter Box");
				String switchChoice = input.next();
				switch (switchChoice) {
				case "1":
					System.out.println("Which cage would you like to clean?");
					for (String key : pets.keySet()) {
						System.out.println(key);
					}
					String cageName = input.next();
					OrganicDog petCageCleaning = findOrganicDog(cageName);
					petCageCleaning.cleanCage();
					System.out.println(cageName + " has a sparkly clean cage!");
					break;
				case "2":
					// build litter box
					System.out.println("Cleaning the litter box");
					decreaseLitterBoxCounter(4);
					break;
				default:
					System.out.println(
							"Not sure what you meant to enter, but if you arent sure what to clean up, clean the breakroom.");
					System.out.println("Humans are a MESS!");
					break;
				}
				break;
			case "8":
				// this will check on the pets
				System.out.println("Name\t|Type\t|Hunger\t|Thirst\t|Boredom |Bathroom |Health ");
				for (String key : pets.keySet()) {
					// System.out.print(key);
					VirtualPet keyPet = findVirtualPet(key);
					System.out.println("------------------------------------------------------------");
					System.out.println(key + "\t|" + keyPet.getPetType() + "\t|" + keyPet.getHungerLevel() + "\t|"
							+ keyPet.getThirstLevel() + "\t|" + keyPet.getBoredomCount() + "\t  |"
							+ keyPet.getExcretionCount() + "\t   |" + keyPet.getHealthCount());
					keyPet.tick();

				}
				System.out.println(
						"***********************************************************************************************");

				System.out.println("Name\t|Type\t|Boredom |Oil Level");
				System.out.println("----------------------------------");
				for (String key : robopets.keySet()) {
					RoboPet keyRoboPet = findRoboPet(key);
					System.out.println(key + "\t|" + keyRoboPet.getPetType() + "\t|" + keyRoboPet.getBoredomCount()
							+ "\t   |" + keyRoboPet.getOilLevel());
					keyRoboPet.roboTick();
					keyRoboPet.valueChecker();
				}

				for (String key : pets.keySet()) {
					VirtualPet keyPet2 = findVirtualPet(key);
					keyPet2.valueChecker();
				}
				litterBoxChecker();
				break;
			case "9":
				// this will call menuItems()
				menuItems();
				break;
			case "quit":
				// this will exit the program
				System.exit(0);
			default:
				System.out.println("Sorry, you will have to enter a selection from the menu");
				break;

			}
		}
		input.close();

	}
	

}
