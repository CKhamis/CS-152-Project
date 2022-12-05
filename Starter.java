import Controller.Controller;
import Messages.Message;
import Model.UserData;
import Model.Workout;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Starter {
    public static <User> void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        UserData user = new UserData();
        ArrayList<Workout> workoutRepository = new ArrayList<>();
        workoutRepository.add(new Workout("C:\\Users\\costi_dmi8dsd\\OneDrive\\Post HS Education\\Semester 7\\Computer Science 152\\Projects\\Project\\images\\Screenshot_20221201_122103.png", "Push Ups", "adf", "tip", "adf", 1, 1, 1));
        workoutRepository.add(new Workout("C:\\Users\\costi_dmi8dsd\\OneDrive\\Post HS Education\\Semester 7\\Computer Science 152\\Projects\\Project\\images\\Screenshot_20221201_122103.png", "Sit Ups", "desc", "tip", "diff", 1, 1, 1));
        workoutRepository.add(new Workout("C:\\Users\\costi_dmi8dsd\\OneDrive\\Post HS Education\\Semester 7\\Computer Science 152\\Projects\\Project\\images\\Screenshot_20221201_122103.png", "Squats", "desc", "tip", "adf", 1, 1, 1));
        workoutRepository.add(new Workout("C:\\Users\\costi_dmi8dsd\\OneDrive\\Post HS Education\\Semester 7\\Computer Science 152\\Projects\\Project\\images\\Screenshot_20221201_122103.png", "Jumping Jacks", "desc", "tip", "diff", 1, 1, 1));
        workoutRepository.add(new Workout("C:\\Users\\costi_dmi8dsd\\OneDrive\\Post HS Education\\Semester 7\\Computer Science 152\\Projects\\Project\\images\\Screenshot_20221201_122103.png", "hjk", "desc", "tip", "adf", 1, 1, 1));
        workoutRepository.add(new Workout("C:\\Users\\costi_dmi8dsd\\OneDrive\\Post HS Education\\Semester 7\\Computer Science 152\\Projects\\Project\\images\\Screenshot_20221201_122103.png", "57", "desc", "adf", "diff", 1, 1, 1));
        workoutRepository.add(new Workout("C:\\Users\\costi_dmi8dsd\\OneDrive\\Post HS Education\\Semester 7\\Computer Science 152\\Projects\\Project\\images\\Screenshot_20221201_122103.png", "345", "desc", "tip", "diff", 1, 1, 1));
        workoutRepository.add(new Workout("C:\\Users\\costi_dmi8dsd\\OneDrive\\Post HS Education\\Semester 7\\Computer Science 152\\Projects\\Project\\images\\Screenshot_20221201_122103.png", "Tifghtle", "desc", "tip", "diff", 1, 1, 1));
        workoutRepository.add(new Workout("C:\\Users\\costi_dmi8dsd\\OneDrive\\Post HS Education\\Semester 7\\Computer Science 152\\Projects\\Project\\images\\Screenshot_20221201_122103.png", "nnn", "desc", "tip", "diff", 1, 1, 1));
        workoutRepository.add(new Workout("C:\\Users\\costi_dmi8dsd\\OneDrive\\Post HS Education\\Semester 7\\Computer Science 152\\Projects\\Project\\images\\Screenshot_20221201_122103.png", "nnnnnnnn", "desc", "tip", "diff", 1, 1, 1));
        new Controller(queue, user, workoutRepository);
    }
}
