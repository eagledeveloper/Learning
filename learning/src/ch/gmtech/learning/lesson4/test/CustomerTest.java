package ch.gmtech.learning.lesson4.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.gmtech.learning.lesson4.Customer;
import ch.gmtech.learning.lesson4.Movie;
import ch.gmtech.learning.lesson4.Rental;

public class CustomerTest {
	
	@Test
	public void testCustomer() {
		Customer customer = new Customer("Stefano Frocio");
		Movie movie1 = new Movie("Ritorno al futuro", 0);
		Rental rental1 = new Rental(movie1 , 5);
		Movie movie2 = new Movie("StarWars Episode 8", 1);
		Rental rental2 = new Rental(movie2 , 10);
		
		customer.addRental(rental1);
		customer.addRental(rental2);
		
		String expected = "Rental Record for Stefano Frocio\n" +
				"\tRitorno al futuro\t6.5\n" +
				"\tStarWars Episode 8\t30.0\n" +
				"Amount owed is 36.5\n" +
				"You earned 3 frequent renter points";
		
		assertEquals(expected, customer.statement());
		
	}

}
