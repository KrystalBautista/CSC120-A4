/**
 * The engine of the train, stores fuel type and fuel levels
 */
public class Engine implements EngineRequirements{
    private FuelType fuelType;
    private double currentFuel;
    private double maxFuel;

    /**
     * Constructs a new engine based on given fuel type/levels
     * @param fuelType
     * @param currentFuel
     * @param maxFuel
     */
    public Engine(FuelType fuelType, double currentFuel, double maxFuel){
        this.fuelType = fuelType;
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;
    }

    /**
     * Returns type of fuel the engine uses
     */
    public FuelType getFuelType(){
        return this.fuelType;
    }

    /**
     * Returns max fuel level of the engine
     */
    public double getMaxFuel(){
        return this.maxFuel;
    }

    /**
     * Returns current fuel levels of the engine
     */
    public double getCurrentFuel(){
        return this.currentFuel;
    }

    /**
     * Refuels engine to max capacity
     */
    public void refuel(){
        this.currentFuel = this.maxFuel;
    }

    /**
     * Attempts to use the engine, decreases fuel and returns success status
     */
    public Boolean go(){
        if (this.currentFuel > 0) {
            this.currentFuel -= 1;
            System.out.println("Fuel remaining: " + this.currentFuel);
            return true;
        }
        return false;
    }
}