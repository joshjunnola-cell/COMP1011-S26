/*You are building a Fitness Tracker that tracks different workout types:
Running
Cycling
Swimming

Each workout:
must be validated
can calculate calories burned
shares some common behavior
 */
import java.util.*;

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
    // Print: "<userName> completed a workout of <duration> minutes"
    // TODO 2:
    // Create an abstract method calculateCalories() that returns a double
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
    // TODO 4:
    // Implement performWorkout()
    // Steps:
    // 1. Print "Running session started..."
    // 2. Call calculateCalories()
    // 3. Call logWorkout()
    // TODO 5:
    // Implement getWorkoutType() → return "Running"
}

// ===== CONCRETE CLASS 2 =====
class CyclingWorkout extends AbstractWorkout {

    private double speed; // km/h

    public CyclingWorkout(String userName, int duration, double speed) {
        super(userName, duration);
        this.speed = speed;
    }

    // TODO 6:
    // Implement calculateCalories()
    // Hint: calories = speed * duration * 2
    // TODO 7:
    // Implement performWorkout()
    // TODO 8:
    // Implement getWorkoutType() → return "Cycling"
}

// ===== CONCRETE CLASS 3 =====
class SwimmingWorkout extends AbstractWorkout {

    private int laps;

    public SwimmingWorkout(String userName, int duration, int laps) {
        super(userName, duration);
        this.laps = laps;
    }

    // TODO 9:
    // Implement calculateCalories()
    // Hint: calories = laps * 10
    // TODO 10:
    // Implement performWorkout()
    // TODO 11:
    // Implement getWorkoutType() → return "Swimming"
}

// ===== UTILITY CLASS (OVERLOADING) =====
class FitnessUtils {

    // TODO 12:
    // Method logSummary(int totalMinutes)
    // Print: "Total workout time: X minutes"
    // TODO 13:
    // Overloaded method logSummary(int totalMinutes, String level)
    // Print: "Total workout time: X minutes - Level: <level>"
}

// ===== MAIN DRIVER =====
public class Assignment1FitnessApp {

    public static void main(String[] args) {

        // TODO 14:
        // Create objects for Running, Cycling, Swimming
        // TODO 15:
        // Store them in a Workout array
        // TODO 16:
        // Loop through workouts:
        // 1. Print workout type
        // 2. Call performWorkout()
        // TODO 17:
        // Create FitnessUtils object
        // Call both versions of logSummary()
    }
}
