package characters;

import java.security.SecureRandom;

import threads.Race;

public class Racer extends Thread{
	private String name;
	private int distanceRun;
	public Racer(String name) {
		this.name = name;
		distanceRun = 0;
	}
	
	public String getRacerName() {
		return name;
	}
	
	@Override
	public void run(){
		while(true) {
			try {
				runFast();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void runFast() throws InterruptedException{
		while(Race.start) {
			sleep(250);
			SecureRandom random = new SecureRandom();
			int movedForward = random.nextInt(50);
			
			distanceRun += movedForward;
			
			System.out.println("Racer " + this.name + " has moved forward by " + movedForward + " and has completed " + distanceRun + " feet of the race.");
			
			if(distanceRun >= Race.raceLength) {
				Race.finishers.add(this);
				System.out.println("Racer " + this.name + " has crossed the finish line.");
				
				if(Race.racers.size() == Race.finishers.size()) {
					Race.start = false;
					System.out.println("The race has finished.");
					for(int position = 0; position < Race.finishers.size(); position++) {
						Racer racer = Race.finishers.get(position);
						System.out.println("Racer " + racer.getRacerName() + " has finished in position " + (position+1));
						//racer.interrupt();
					}
				}
			}
		}
	}
}
