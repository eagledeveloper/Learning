package ch.gmtech.learning.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PresenterChooser {
	
	private static List<String> presenters = Arrays.asList("Gennaro", "Dario", "Mattia", "Stefano", "Valentino",
			"Vacca", "Enrico", "Manlio", "Alessandro", "Chicco", "Pino", "Matteo", "Massi", "Gabri");

	public static void main(String[] args) {
		
		List<String> newPresenters = new ArrayList<String>();
		newPresenters.addAll(presenters);
		
		System.out.println("Total number of possible presenters: " + presenters.size());
		
		if(args.length > 0) {
			
			List<String> presentersToRemove = new ArrayList<String>();
			
			for(int i = 0; i < args.length; i++) {
				
				presentersToRemove.add(args[i]);
				
			}
			
			System.out.println("Presenters to remove: " + presentersToRemove);
			
			newPresenters.removeAll(presentersToRemove);
			
		}
		
		System.out.println("Papable presenters number: " + newPresenters.size());
		
		Random random = new Random(System.currentTimeMillis());
		int index = random.nextInt(newPresenters.size());
		
		System.out.println("Presenter selected: " + newPresenters.get(index));
		
	}

}
