package ch.gmtech.learning.lesson4.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.gmtech.learning.lesson4.Customer;
import ch.gmtech.learning.lesson4.Movie;
import ch.gmtech.learning.lesson4.Rental;

public class CustomerTest {
	
	@Test
	public void testCustomer() {
		Customer customer = new Customer("Ugo Campione");
		Movie movie1 = new Movie("Ritorno al futuro", Movie.REGULAR);
		Rental rental1 = new Rental(movie1 , 5);
		Movie movie2 = new Movie("StarWars Episode 8", Movie.NEW_RELEASE);
		Rental rental2 = new Rental(movie2 , 10);
		Movie movie3 = new Movie("Dory", Movie.CHILDRENS);
		Rental rental3 = new Rental(movie3 , 2);
		
		customer.addRental(rental1);
		customer.addRental(rental2);
		customer.addRental(rental3);
		
		String expected = "Rental Record for Ugo Campione\n" +
				"\tRitorno al futuro\t6.5\n" +
				"\tStarWars Episode 8\t30.0\n" +
				"\tDory\t1.5\n" +
				"Amount owed is 38.0\n" +
				"You earned 4 frequent renter points";
		
		assertEquals(expected, customer.statement());
	}

}
