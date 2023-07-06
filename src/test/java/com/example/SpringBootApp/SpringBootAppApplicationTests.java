package com.example.SpringBootApp;

import com.example.SpringBootApp.model.Animal;
import com.example.SpringBootApp.repo.AnimalRepo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringBootAppApplicationTests {

	@Autowired
	AnimalRepo animalRepo;

	@Test
	@Order(1)
	public void testCreate() {

		long ID = 1;

		Animal animal = new Animal();

		animal.setId(ID);
		animal.setSpecies("Frog");
		animal.setName("Herbert");

		animalRepo.save(animal);

		assertNotNull(animalRepo.findById(ID).get());

		System.out.println("Adding Herbert the Frog worked!");

	}

	@Test
	@Order(2)
	public void testReadAll() {
		List<Animal> list = animalRepo.findAll();

		//assertThat(list).size().isGreaterThan(0);
		assertTrue("Animal list is greater than zero", list.size() > 0);
	}

	@Test
	@Order(3)
	public void testReadById() {

		long ID = 1;

		Animal animal = animalRepo.findById(ID).get();

		assertEquals("Frog", animal.getSpecies());
		assertEquals("Herbert", animal.getName());

	}

	@Test
	@Order(4)
	public void testUpdate() {

		long ID = 1;

		Animal a = animalRepo.findById(ID).get();

		a.setName("Froppy");
		animalRepo.save(a);

		assertNotEquals("Herbert", animalRepo.findById(ID).get().getName());

		// To ensure the species doesn't change such as going null
		assertEquals("Frog", animalRepo.findById(ID).get().getSpecies());

		// To ensure it does equal Froppy
		assertEquals("Froppy", animalRepo.findById(ID).get().getName());

	}

	@Test
	@Order(5)
	public void testDelete() {

		long ID = 1;

		animalRepo.deleteById(ID);

		assertFalse(animalRepo.existsById(ID));

	}





}
