import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.Random;

/**
 * Created by fdebi on 4/26/2017.
 */
public class Bay {
    public int duration;
    public KQueue<Car> waiting;
    int washchanger = 0;
    //this takes the wash time or duration
    public Bay (int washing)
    {
        duration = washing;
        this.waiting = new LLQueue<Car>();

    }
    //initally was a simple boolean but is controled by an integer value which is changed in add bay
    public boolean isempty(boolean cleaning)
    {
        if(washchanger > 0)
        {
            washchanger = 0;
            return cleaning;
        }

        return !cleaning;
    }
    public int size()
    {
        return waiting.size();
    }
    public boolean waitingline()
    {
        if(waiting.size() > 0)
        {
            return true;
        }
        return false;
    }
    public void addToBay(Car car, boolean change)
    {

        //when a car is firs added it checks if the line is empty or not and weather the bay is full or no
        if(waiting.size() == 0 && change == false)
        {
            //car = new Car(newStep);
            System.out.println("A Car was added to the Bay: " + car.arrivalTime());
            waiting.enqueue(car);
            waiting.dequeue();
            //changes the boolean of isempty
            washchanger++;
        }
        else if (change == true)
        {
            System.out.println("A Car was added to the wait line at this time: " + car.arrivalTime());
            waiting.enqueue(car);
        }
        //if there is a line and a car is being added at the same time then it will deque then enqueue
        else if(change == false && waiting.size() > 0)
        {
            waiting.dequeue();
            waiting.enqueue(car);
        }

        if(waiting.size() < 5)
        {
            System.out.println(waiting.toString());
        }

    }
    public void callNextCar(boolean change)
    {
        //in the case a car is not being added but I need to dequeue when the bay is empty
        if(change == false && waiting.size() > 0) {
            waiting.dequeue();
            washchanger++;
        }
    }

}
