// This file gives access to the underlying datafile and stores the data in the Workout class.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileAccess {
  
  public static Workouts loadWorkouts() {
    Workouts retval = new Workouts();
    
    try { // What is this try/catch thing, and why do I need it?
      Scanner scanner = new Scanner(new File(Config.WORKOUTFILE));
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] fields = line.split(",");
        String name = fields[0];
        Workouts.Equipment equipment = Workouts.Equipment.valueOf(fields[1]);
        Workouts.Muscle primaryMuscle = Workouts.Muscle.valueOf(fields[2]);
        Workouts.Muscle secondaryMuscle = Workouts.Muscle.valueOf(fields[3]);
        String desc = fields[4];
        String reminders = fields[5];
        retval.addWorkout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
      }
      scanner.close();
    }
    catch (FileNotFoundException e) // What is an exception?
    {
      System.out.println("Unable to find workouts file. Is it in the same directory as the executable?\nError:"+e.toString());
    }
    return retval;
  }

}
