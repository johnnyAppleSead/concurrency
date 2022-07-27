package runner;

import characters.Racer;
import threads.Race;

public class Main {
	public static void main(String... args) {		
		Racer racer1 = new Racer("Tom");
		Racer racer2 = new Racer("Harry");
		
		Race.racers.add(racer1);
		Race.racers.add(racer2);
		
		for(Racer racer : Race.racers) {
			System.out.println("Racer " + racer.getRacerName() + " has reached the starting line.");
			racer.start();
		}
		
		System.out.println("The race has started.");
		Race.start = true;
	}
}
