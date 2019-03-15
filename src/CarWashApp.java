import java.util.NoSuchElementException;


/**
 *
 * 
 * @author Fabien Debies
 * @version May 1, 2017
 */
public class CarWashApp {

	/**
	 * Runs a series of tests.
	 */
	public static void main(String[] args) {
		//Initalize the day which is converted into minutes so 600 steps = 10 hours
		int day = 600;
		int someday = ValidatedInputReader.getInteger("Time for the day: ", day, ".");
		//This clairifies how long you want to see the car to be in the carwash 3 or 4 minutes
		int sometime = ValidatedInputReader.getInteger("Time for the day: ", 3, ".");
		//Initalizes the simulation
		CarWashSim Simulations = new CarWashSim(sometime);
		//Steps through the simulations
		for(int i = 1; i <= someday; i++) {
			//Calls the washing method inside the sim which checks the bay if there is a car if there isnt then it will add a car a the chance of RNG.
			Simulations.washing(i);
			//This accounts for the lost steps when a car is being washed so that the integer i is not behind
			i += Simulations.Stepping;
			//I reset the value each time so i am not over counting.
			Simulations.Stepping = 0;
		}
		System.out.println("Total cars serviced " + Simulations.carServiced);
	}
	
	

	
}	


