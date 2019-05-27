package virtualPetShelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelter {
	Scanner input = new Scanner(System.in);
	Map<String, VirtualPet> pets = new HashMap<>();
	int welcomeCount = 0;

	public void addVirtualPet(VirtualPet petObject) {
		pets.put(petObject.getPetName(), petObject);

	}

	public VirtualPet findVirtualPet(String petName) {
		return pets.get(petName);
	}

	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}

	public void removeAVirtualPet(VirtualPet petName) {
		pets.remove(petName.getPetName(), petName);

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
				// Play with a pet
				System.out.println("Which pet would you like to play with?");
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
			case "4":
				// remove pet
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
			case "5":
				// Add a pet to shelter
				System.out.println("What is the name of the pet?");
				String petName = input.next();
				System.out.println("What kind of pet is the pet?");
				String petType = input.next();
				VirtualPet petObject = new VirtualPet(petName, petType);
				addVirtualPet(petObject);
				petObject.setInitialValuesToRandom();
				System.out.println("We will take good care of this pet and see that a home is found");

				break;
			case "6":
				// take a pet on a bathroom break
				System.out.println("Which pet are you taking on a Bathroom break?");
				String petBathroomName = input.next();
				VirtualPet petBathroom = findVirtualPet(petBathroomName);
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
				System.out.println("Cleaning up after the pets");
				break;
			case "8":
				// this will check on the pets
				System.out.println("Name\t|Type\t|Hunger\t|Thirst\t|Boredom |Bathroom|Health");
				for (String key : pets.keySet()) {
					// System.out.print(key);
					VirtualPet keyPet = findVirtualPet(key);
					System.out.println(
							"---------------------------------------------------------------------------------");
					System.out.println(key + "\t|" + keyPet.getPetType() + "\t|" + keyPet.getHungerLevel() + "\t|"
							+ keyPet.getThirstLevel() + "\t|" + keyPet.getBoredomCount() + "\t  |"
							+ keyPet.getExcretionCount() + "\t   |" + keyPet.getHealthCount());
					keyPet.tick();

				}
				System.out.println(
						"***********************************************************************************************");
				for (String key : pets.keySet()) {
					VirtualPet keyPet2 = findVirtualPet(key);
					keyPet2.valueChecker();
				}
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

	}

}
