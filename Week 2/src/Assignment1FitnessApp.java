/*You are building a Fitness Tracker that tracks different workout types:
Running
Cycling
Swimming

Each workout:
must be validated
can calculate calories burned
shares some common behavior
 */

// ===== INTERFACE =====
interface Workout {

    void performWorkout();

    String getWorkoutType();
}

// ===== ABSTRACT CLASS =====
abstract class AbstractWorkout implements Workout {

    protected String userName;
    protected int duration; // in minutes

    public AbstractWorkout(String userName, int duration) {
        this.userName = userName;
        this.duration = duration;
    }

    // TODO 1:
    // Create a concrete method logWorkout()
    public void logWorkout(double amount) {
        System.out.println(userName + " completed a workout of " + duration + " minutes.");
    }
    // Print: "<userName> completed a workout of <duration> minutes"
    // TODO 2:
    // Create an abstract method calculateCalories() that returns a double
    public abstract double calculateCalories();
}

// ===== CONCRETE CLASS 1 =====
class RunningWorkout extends AbstractWorkout {

    private double distance; // in km

    public RunningWorkout(String userName, int duration, double distance) {
        super(userName, duration);
        this.distance = distance;
    }

    // TODO 3:
    // Implement calculateCalories()
    // Hint: calories = distance * 60
    
    @Override
    public double calculateCalories() {
        double calories = distance*60;
        System.out.println("User has burned: " + calories + " calories.");
        return calories;
    }
    // TODO 4:
    // Implement performWorkout()
    // Steps:
    // 1. Print "Running session started..."
    // 2. Call calculateCalories()
    // 3. Call logWorkout()
    @Override
    public void performWorkout() {
        System.out.println("Running session started.");

        calculateCalories();
        logWorkout(distance);
    }
    // TODO 5:
    // Implement getWorkoutType() → return "Running"
    @Override
    public String getWorkoutType() {
        return "Running";
    }
}

// ===== CONCRETE CLASS 2 =====
class CyclingWorkout extends AbstractWorkout {

    private double speed; // km/h
    private int calories;

    public CyclingWorkout(String userName, int duration, double speed) {
        super(userName, duration);
        this.speed = speed;
    }

    // TODO 6:
    // Implement calculateCalories()
    // Hint: calories = speed * duration * 2
    @Override
    public double calculateCalories() {
        double calories = speed * duration * 2;
        return calories;
    }
    // TODO 7:
    // Implement performWorkout()
    @Override
    public void performWorkout() {
        System.out.println("Cycling session started.");
        calculateCalories();
        logWorkout(speed);
    }
    // TODO 8:
    // Implement getWorkoutType() → return "Cycling"
    @Override
    public String getWorkoutType() {
        return "Cycling";
    }
}

// ===== CONCRETE CLASS 3 =====
class SwimmingWorkout extends AbstractWorkout {

    private int laps;
    private int calories;

    public SwimmingWorkout(String userName, int duration, int laps) {
        super(userName, duration);
        this.laps = laps;
    }

    // TODO 9:
    // Implement calculateCalories()
    // Hint: calories = laps * 10
    @Override
    public double calculateCalories() {
        calories = laps * 10;
        return calories;
    }
    // TODO 10:
    // Implement performWorkout()
    @Override
    public void performWorkout() {
        System.out.println("Swimming session started.");
        calculateCalories();
        logWorkout(laps);
    }
    // TODO 11:
    // Implement getWorkoutType() → return "Swimming"
    @Override
    public String getWorkoutType() {
        return "Swimming";
    }
}

// ===== UTILITY CLASS (OVERLOADING) =====
class FitnessUtils {

    // TODO 12:
    // Method logSummary(int totalMinutes)
    // Print: "Total workout time: X minutes"
    public void logSummary(int totalMinutes) {
        System.out.println("Total workout time: " + totalMinutes);
        System.out.println("=============================");
    }
    
    // TODO 13:
    // Overloaded method logSummary(int totalMinutes, String level)
    // Print: "Total workout time: X minutes - Level: <level>"
    public void logSummary(int totalMinutes, String level) {
        System.out.println("Total workout time: " +totalMinutes + " - Level: " + level);
    }
}

// ===== MAIN DRIVER =====
public class Assignment1FitnessApp {

    public static void main(String[] args) {

        // TODO 14:
        // Create objects for Running, Cycling, Swimming
        AbstractWorkout w1 = new RunningWorkout("Josh", 20, 10);
        AbstractWorkout w2 = new CyclingWorkout("Jo", 15, 7.5);
        AbstractWorkout w3 = new SwimmingWorkout("Bart", 35, 25);
        // TODO 15:
        // Store them in a Workout array
        AbstractWorkout[] workouts = {w1, w2, w3};
        // TODO 16:
        // Loop through workouts:
        // 1. Print workout type
        // 2. Call performWorkout()
        int totalMinutes = 0;

        for (AbstractWorkout workout : workouts) {
            System.out.println("\nWorkout Type: " + workout.getWorkoutType());
            workout.performWorkout();
            totalMinutes += workout.duration; //adds time together
        }
        // TODO 17:
        // Create FitnessUtils object
        // Call both versions of logSummary()
        FitnessUtils utils = new FitnessUtils();
        utils.logSummary(totalMinutes);
        utils.logSummary(totalMinutes, "Intermediate");
    }
}
