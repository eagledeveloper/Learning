package ch.gmtech.learning.lesson1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PresenterChooser {
	
	private static List<String> presenters = Arrays.asList("Gennaro", "Dario", "Mattia", "Stefano", "Valentino",
			"Vacca", "Enrico", "Manlio", "Alessandro", "Chicco", "Pino", "Matteo", "Massi", "Gabri");

	public static void main(String[] args) throws IOException {
		
		String pathRegistered = "/Data/Reporting/Valentino/Learning/registered.txt";
		String pathExcluded = "/Data/Reporting/Valentino/Learning/excluded.txt";
		
		List<String> registered = list(pathRegistered);
		List<String> excluded = list(pathExcluded);
		
		System.out.println("Total number of possible presenters: " + presenters.size());
		System.out.println("Presenters to remove: " + excluded);
		
		registered.removeAll(excluded);
		
		System.out.println("Papable presenters number: " + registered.size());
		
		Random random = new Random(System.currentTimeMillis());
		int index = random.nextInt(registered.size());
		
		System.out.println("Presenter selected: " + registered.get(index));
		
	}
	
	public static List<String> list(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));

		String line = null;
		List<String> returnList = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			returnList.add(line);
		}
		br.close();
		return returnList;
	}

}
