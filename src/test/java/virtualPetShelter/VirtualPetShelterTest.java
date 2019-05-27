package virtualPetShelter;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {
	
	VirtualPetShelter underTest;
	VirtualPet ruttiTest;
	VirtualPet sophieTest;
	
	
	
	@Before
	public void testSetUp(){
		underTest = new VirtualPetShelter();
		ruttiTest = new VirtualPet("Rutti", "Dog");
		sophieTest = new VirtualPet("Sophie", "Dog");
		
	}

	
	@Test
	public void shouldBeAbleToAddPet() {
		underTest.addVirtualPet(ruttiTest);
		VirtualPet retriever = underTest.findVirtualPet("Rutti");
		assertThat(retriever, is(ruttiTest));
	}
	
	
	
	@Test
	public void shouldBeAbleToAddTwoPets() {
		underTest.addVirtualPet(ruttiTest);
		underTest.addVirtualPet(sophieTest);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		//assertThat(allPets, containsInAnyOrder(ruttiTest, sophieTest));
		assertEquals(2, allPets.size());
	}
	
	@Test
	public void shouldBeAbleToRemoveAPet() {
		underTest.addVirtualPet(ruttiTest);
		underTest.addVirtualPet(sophieTest);
		underTest.removeAVirtualPet(sophieTest);
		VirtualPet adoptedPet = underTest.findVirtualPet(sophieTest.getPetName());
		assertThat(adoptedPet, is(nullValue()));
		
	}
	@Test
	public void shouldBeAbleToInteractWithPet() {
		VirtualPet singlePet = underTest.findVirtualPet("Rutti");
		singlePet.bathroom(5);
	}

}
