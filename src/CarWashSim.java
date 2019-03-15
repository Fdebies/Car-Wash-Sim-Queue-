import java.util.Random;

/**
 * Created by fdebi on 4/26/2017.
 */
public class CarWashSim {

    //The instance variable here are used for different functions of the carwash that let it know some info about when to wash and when to count.
    public boolean cleaning = false;
    int counter = 0;
    public Bay bay;
    public Random rand;
    public int duration;
    public int Stepping;
    public int reset;
    public int carServiced;
    public Average average;

    //the simulation take the duration which is the time entered you want the cars to be washing for
    public CarWashSim(int duration)
    {
        this.duration = duration;
        this.reset = duration;
        bay = new Bay(duration);
        rand = new Random();
        average = new Average();

    }
    //THis step is called when there is a chance to add a car at every step
    public void addCar(int stepping) {
        //random gen used for a 25% chance to add cars
            int randCar = rand.nextInt(4);
            //two if statements are used to test whether there is a car in the bay and this would change where the car is added to.
            if (randCar < 1 && duration == reset) {
                Car car = new Car(stepping);
                //the boolean cleaning is automatically set to false meaning that there is no car in the bay
                bay.addToBay(car, cleaning);
            }
        if (randCar < 1 && duration < reset) {
            Car car = new Car(stepping);
            //the boolean cleaning is given the opposite meaning that there is a car in the bay
            bay.addToBay(car, !cleaning);
        }

            else {
                //Although in the bay there are methods that dequeue. However its only the case when a car is being added to the bay.
                // this will ensure that despite no cars coming a car will always be added to the bay.
                //waitingline is a boolean expressiong that allows this to go through.
                if(bay.waitingline())
                {
                    bay.callNextCar(cleaning);
                }
                System.out.println("No Cars arrived at this time: " + stepping);
                System.out.println("The size of the line is: " + bay.size());
            }
    }
    //This take ths parameter for the current time we are at in the simulation which is stepping. notice I have two types
    //However the second stepping is used to be the lost time that the current time loses while im washing a car
    public void washing(int stepping)
    {
        //checks if bay is empty
        if(bay.isempty(cleaning) == false)
        {
            System.out.println("The Bay is not Empty at: " + stepping);
            while(duration != 0) {

                System.out.println("The Bay is not empty until: " + duration);
                Stepping++;
                duration--;
                this.addCar(stepping);
                //keeps the count of the waiting line
                if(bay.waitingline())
                {
                    counter++;
                    System.out.println("The amount of cars in the line is: " + bay.size() + "\n" + "They have waiting for: " + counter);

                }
                //adds the values of the waiting line to an array
                else
                {
                    average.addtoArray(counter);
                    counter = 0;
                }

            }
            //resets duration to it original time
            duration = reset;
            carServiced++;
        }
        else
        {
            this.addCar(stepping);
        }
        //when the steps are getting near 600 then I call average it might pop out twice because the program reaches 600
        //but in other cases it will get to 600 however that is when a car is in the bay and being washed
        if (stepping > 595)
    {
        System.out.println( "The average wait time for a carwash that lasts: " + reset + " is " + average.calculateMean());

    }

    }
}
