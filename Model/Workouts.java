package Model;

import javax.swing.*;
import java.util.ArrayList;

public class Workouts extends Model{
    private ArrayList<String> workouts;
    public void addWorkout(String exercise){
        workouts.add(exercise);
    }
    public ArrayList<String> getWorkouts(){
        return workouts;
    }
}
