import java.util.ArrayList;

/**
 * Represents a train that has an engine and cars
 */
public class Train implements TrainRequirements {
    private Engine engine;
    private ArrayList<Car> cars;

    /**
     * Constructs a train with an engine and cars
     */
    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, currentFuelLevel, fuelCapacity);
        this.cars = new ArrayList<>();

        for (int i = 0; i < nCars; i++){
            this.cars.add(new Car(passengerCapacity));
        }
    }

    /**
     * Returns train's engine
     */
    public Engine getEngine(){
        return this.engine;
    }

    /**
     * Returns car at a given index
     */
    public Car getCar(int i){
        if (i >= 0 && i < this.cars.size()){
            return this.cars.get(i);
        }
        return null;
    }

    /**
     * Returns max passenger capacity of the train
     */
    public int getMaxCapacity(){
        int total = 0;
        for (Car c: cars){
            total += c.getCapacity();
        }
        return total;
    }

    /**
     * Returns number of open seats on the train
     */
    public int seatsRemaining(){
        int remaining = 0;
        for (Car c: cars){
            remaining += c.seatsRemaining();
        }
        return remaining;
    }

    /**
     * Prints the manifest for each car on the train
     */
    public void printManifest(){
        for (int i = 0; i < cars.size(); i++){
            System.out.println("Car " + i + ":");
            cars.get(i).printManifest();
        }
    }

    public static void main(String[] args){
        // Create a train with 2 cars and 2 seats per car
        Train train = new Train(FuelType.ELECTRIC, 10.0, 50.0, 2, 2);

        // Create some passengers
        Passenger alice = new Passenger("Alice");
        Passenger bob = new Passenger("Bob");
        Passenger charlie = new Passenger("Charlie");

        // Board them onto cars
        alice.boardCar(train.getCar(0));
        bob.boardCar(train.getCar(0));
        charlie.boardCar(train.getCar(1));

        // Print manifest to see who is on board
        System.out.println("\nTrain Manifest:");
        train.printManifest();

        // Move the train using the engine
        System.out.println("\nTrain is moving...");
        while (train.getEngine().go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Train is out of fuel.");
    }

}
