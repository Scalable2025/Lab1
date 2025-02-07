package com.example.lab1;

import com.example.lab1.models.User;
import com.example.lab1.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Lab12ApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}

	@Test
	void createUser_withValidInput_shouldReturnSameNameAndEmail() {
		// Arrange
		User newUser = new User("Bob", "bob@java.com", 30);

		// Act
		User createdUser = userService.createUser(newUser);

		// Assert
		assertEquals(createdUser.getName(),newUser.getName(), "Name is not the same");
        assertEquals(createdUser.getEmail(), newUser.getEmail(), "Email is not the same");
	}

}
