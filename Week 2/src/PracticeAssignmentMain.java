// Interface

interface FuelConsumer {
    void refuel(double liters);
}

// Abstract Class Vehicle should implement FuelConsumer
//Begin with completing the class signature
 Vehicle  {
    // add access spcifiers to these variables ensuring they are available only to 
    //this class and its sub classes
    String brand;
    protected String model;
    protected double fuelLevel;

    public Vehicle(String brand, String model, double fuelLevel) {
        //complete the construtor code
    }

    // Abstract method (must be implemented by subclasses)
    public abstract void start();

    // Concrete method (shared behavior)
    public void stop() {
             System.out.println(brand + " " + model + " has stopped.");
    }

    //put the correct annotation here
    public void refuel(double liters) {
        //increment fuel level by the provided parameter value
        System.out.println(brand + " " + model + " refueled with " + liters + " liters. Current fuel: " + fuelLevel);
    }
}

// Concrete class 1: Car is a subclass of Vehicle
//complete class signature
class Car {
    //add access specifier to this instance variable. Only available inside class code
    int numberOfDoors;

    public Car(String brand, String model, double fuelLevel, int numberOfDoors) {
        //appropriate initialization of the first 3 parameters
        this.numberOfDoors = numberOfDoors;
    }

    //which method MUST be overridden
    //complete method signature
    @Override
    public  {
        System.out.println("Car " + brand + " " + model + " is starting. Doors: " + numberOfDoors);
    }
}

// Concrete class 2: Motorcycle is a subclass of Vehicle
//complete class signature
class Motorcycle  {
    //make this variable 'visible' only in the class definition;add access specifier
    boolean hasSidecar;

    public Motorcycle(String brand, String model, double fuelLevel, boolean hasSidecar) {
        //appropriate initialization of the first 3 parameters
        this.hasSidecar = hasSidecar;
    }

    //put in the missing annotation
    public void start() {
        System.out.println("Motorcycle " + brand + " " + model + " is starting. Sidecar: " + hasSidecar);
    }
}

// Concrete class 3: Truck is a subclass of Vehicle
//complete class signature
class Truck {
    //access of this variable is limited to the class; add access specifier
    double loadCapacity;

    public Truck(String brand, String model, double fuelLevel, double loadCapacity) {
        super(brand, model, fuelLevel);
        this.loadCapacity = loadCapacity;
    }

    //overeride the method that NEEDS to be overriden in this class
    //print a clear and complete message similar to other concrete classes 
    //showing brand, model and load capacity
    @Override
   
}

// Main class
public class PracticeAssignmentMain {
    public static void main(String[] args) {
        // Polymorphism: treat all vehicles as Vehicle
        //Create a Car object with parameters "Toyota", "Corolla", 50, 4
        //Create a Motorcycle with parameters "Harley-Davidson", "Iron 883", 15, false
        //Create a Truck with parameters "Volvo", "FH16", 200, 20
        Vehicle[] fleet = 
        // Loop through all vehicles
        for (Vehicle v : fleet) {
            v.start();          // Runtime polymorphism: actual start() depends on the type
            v.refuel(10);       // Shared behavior from abstract class
            v.stop();           // Shared behavior from abstract class
            System.out.println();
        }
    }
}
