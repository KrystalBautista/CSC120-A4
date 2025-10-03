import java.util.ArrayList;

/**
 * Represents a passenger car in a train, contains list of passengers & capacity
 */
public class Car implements CarRequirements{
    private int capacity;
    private ArrayList<Passenger> passengers;

    /**
     * Constructs a new car with a given seat capacity
     * @param capacity
     */
    public Car(int capacity){
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    /**
     * Returns max capacity of the car
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * Returns number of remaining seats
     */
    public int seatsRemaining(){
        return this.capacity - this.passengers.size();
    }

    /**
     * Attempts to add a passenger to the car
     */
    public Boolean addPassenger(Passenger p){
        if(!this.passengers.contains(p) && this.seatsRemaining() > 0){
            this.passengers.add(p);
            return true;
        }
        return false;
    }

    /**
     * Attempts to remove a passenger from car
     */
    public Boolean removePassenger(Passenger p){
        return this.passengers.remove(p);
    }

    /**
     * Prints a manifest of all passengers in the car
     */
    public void printManifest(){
        if(this.passengers.isEmpty()){
            System.out.println("This car is empty.");
        }
        else{
            for (Passenger p: this.passengers){
                System.out.println(p.getName());
            }
        }
    }

}