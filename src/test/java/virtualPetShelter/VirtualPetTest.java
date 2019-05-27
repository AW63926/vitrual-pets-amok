package virtualPetShelter;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class VirtualPetTest {
	VirtualPet underTest = new VirtualPet("Fido", "Dog");

	@Test
	public void hungerLevelShouldReturnOne() {
		int result = underTest.increaseHungerLevel(1);
		assertEquals(1, result);
	}

	@Test
	public void hungerLevelShouldReturnTwo() {
		int result = underTest.increaseHungerLevel(2);
		assertEquals(2, result);

	}

	@Test
	public void hungerLevelShouldBeIncreasedByAddingAmtsGiven() {
		underTest.increaseHungerLevel(2);
		underTest.increaseHungerLevel(2);
		int result = underTest.getHungerLevel();
		assertEquals(4, result);

	}

	@Test
	public void hungerLevelShouldReturnTen() {
		underTest.increaseHungerLevel(5);
		underTest.increaseHungerLevel(2);
		underTest.increaseHungerLevel(3);
		int result = underTest.getHungerLevel();
		assertEquals(10, result);
	}



	@Test
	public void shouldIncreaseThirstCounter() {
		int result = underTest.increaseThirstValue(1);
		assertEquals(1, result);
	}

	@Test
	public void shouldIncreaseThirstCountByFiveAndReturnFive() {
		underTest.increaseThirstValue(5);
		int result = underTest.getThirstLevel();
		assertEquals(5, result);
	}

	


	@Test
	public void shouldIncreaseBoredomCounterByOne() {
		underTest.increaseBoredomCounter(1);
		int result = underTest.getBoredomCount();
		assertEquals(1, result);

	}

	

	@Test
	public void shouldIncreaseHealthCounter() {
		underTest.increaseHealthCounter(1);
		int result = underTest.getHealthCount();
		assertEquals(1, result);
	}

	

	@Test
	public void shouldIncreaseExcretionCounter() {
		underTest.increaseExcretionCounter(1);
		int result = underTest.getExcretionCount();
		assertEquals(1, result);
	}

	

	@Test
	public void shouldDecreaseHungerWhenPetEats() {
		underTest.increaseHungerLevel(5);
		underTest.eat(3);
		int result = underTest.getHungerLevel();
		assertEquals(2, result);
	}

	@Test
	public void shouldIncreaseThirstValueThenSubrtactFromThirstValue() {
		underTest.increaseThirstValue(10);
		underTest.drink(5);
		int result = underTest.getThirstLevel();
		assertEquals(5, result);
	}
	@Test
	public void shouldDecreaseThirstWhenPetDrinks() {
		underTest.increaseThirstValue(5);
		underTest.drink(3);
		int result = underTest.getThirstLevel();
		assertEquals(2, result);
	}
	@Test
	public void shouldDecreaseExcretionCountWhenBathroomisCalled() {
		underTest.increaseExcretionCounter(5);
		underTest.bathroom(3);
		int result = underTest.getExcretionCount();
		assertEquals(2, result);
		
	}
	@Test
	public void hungerLevelShouldReturnFiveAfterSubtraction() {
		underTest.increaseHungerLevel(10);
		underTest.eat(5);
		int result = underTest.getHungerLevel();
		assertEquals(5, result);
	}

	@Test
	public void hungerLevelShouldSubtractValueFromExistingTotal() {
		underTest.increaseHungerLevel(2);
		underTest.eat(1);
		int result = underTest.getHungerLevel();
		assertEquals(1, result);
	}
	@Test
	public void boredomShouldDecreaseWhenPlayIsCalled() {
		underTest.increaseBoredomCounter(5);
		underTest.play(2);
		int result = underTest.getBoredomCount();
		assertEquals(3, result);
	}
	@Test
	public void shouldIncreaseSleepyCounter() {
		underTest.increaseSleepyCounter(1);
		int result = underTest.getSleepyCount();
		assertEquals(1, result);
	}
	@Test
	public void shouldDecreaseSleepyCounterWhenSleepIsCalled() {
		underTest.increaseSleepyCounter(5);
		underTest.sleep(2);
		int result = underTest.getSleepyCount();
		assertEquals(3, result);
		
	}
	@Test
	public void shouldNameThePet() {
		underTest.givePetName("Fido");
		String petName = underTest.getPetName();
		assertEquals("Fido", petName);
	}

	@Test
	public void shouldGivePetType() {
		underTest.assignPetType("Dog");
		String type = underTest.getPetType();
		assertEquals("Dog", type);
		
	}
	@Test
	public void shouldGenerateRandomNumberBetweenZeroandTen() {
		int random = underTest.generateRandomNumber();
		assertEquals(null, random);
	}
	@Test
	public void shouldGenerateRandomBetweenZeroAndThree() {
		underTest.generateRandBetweenZeroAndTwo();
	}
}
