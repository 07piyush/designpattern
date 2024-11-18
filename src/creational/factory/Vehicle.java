package creational.factory;

public interface Vehicle {

	//Vehicle interface makes sure the instantiation logic 
	void move();
	
/*
 * 
Encapsulation of Object Creation: Hides the instantiation logic, 
making code cleaner and focusing only on the interface.

Improved Code Readability: Code becomes more readable as the pattern 
abstracts the creation of complex objects behind a factory interface.

Flexibility with Subclasses: Allows easy creation of objects of different 
subclasses, giving flexibility in returning any subclass type based on conditions.

Promotes Loose Coupling: The client only knows the factory interface, 
reducing dependencies between classes.

Supports Open/Closed Principle: New types of products can be added without 
modifying existing code, making the system extensible.

Centralized Object Management: Consolidates object creation in one place, 
which can ease management and debugging.

Enhances Testability: Facilitates easier testing and mocking by providing 
interfaces that can return different test-specific objects.
 *
 * */
}
