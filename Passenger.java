/**
 * Represents a passenger who can board and exit cars
 */
public class Passenger implements PassengerRequirements {
    
    private String name;

    /**
     * Construsts a passenger with the given name
     * @param name
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Returns passenger's name
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     * Attempts to board specified car
     */
    public void boardCar(Car c){
        if (!c.addPassenger(this)){
            System.out.println(this.name + " could not board: Car is full or already onboard");
        }
    }

    /**
     * Attempts to get off specified car
     */
    public void getOffCar(Car c){
        if (!c.removePassenger(this)){
            System.out.println(this.name + " is not in this car.");
        }
    }
}
