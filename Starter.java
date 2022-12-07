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
        workoutRepository.add(new Workout("images/Diamond Pushup.jpg", "Diamond Push Ups", "Put your hands in a 'diamond shape' under your chest and proceed as if it is a regular push up", "Tip: Make sure your thumbs and index fingers are touching", "Difficult", 3));
        workoutRepository.add(new Workout("images/Donkey Kick.jpg", "Donkey Kicks", "Go on all fours. Extend and lift one leg at a time while not moving anything else.", "Tip: face forward and do not twist your hips", "Easy", 2));
        workoutRepository.add(new Workout("images/Dumbbell Curl.jpg", "Dumbbell Curls", "Stand with knees slightly bent. One at a time, raise one hand to your shoulder with dumbbell.", "Tip: Keep elbow stationary", "Medium", 3));
        workoutRepository.add(new Workout("images/Hand Stand.jpg", "Hand Stand", "Carefully place hands on floor, shoulder width apart. raise both legs to the ceiling.", "Tip: Do not fall", "Extreme", 5));
        workoutRepository.add(new Workout("images/Dumbbell Pushup.jpg", "Dumbbell Push Ups", "Place dumbbells shoulder width apart, with handles going vertical to you. Grab handles and do push up.", "Tip: Do not use round dumbbells", "Hard", 3));
        workoutRepository.add(new Workout("images/Jumping Jack.jpg", "Jumping Jacks", "You've done jumping jacks before....right?", "Tip: Jack is not needed to do a jumping jack", "Easy", 1));
        workoutRepository.add(new Workout("images/Lunge.jpg", "Lunges", "Slowly and carefully walk forward, but with legs spread very far forward and backward", "Tip: DO not fall sideways", "Medium", 6));
        workoutRepository.add(new Workout("images/Pull Up.jpg", "Pull Ups", "Grab bar above you. With both arms, pull yourself up until your chin reaches above bar.", "Tip: Try starting out with assisted pull ups if too hard", "Hard", 3));
        workoutRepository.add(new Workout("images/Push Up.jpg", "Push Ups", "You better know how to do this smh", "Tip: Try your best to have smooth motion", "Hard", 2));
        workoutRepository.add(new Workout("images/Shoulder Raise.jpg", "Shoulder Raises", "desc", "tip", "diff", 1));
        workoutRepository.add(new Workout("images/Sit Up.jpg", "nnnnnnnn", "desc", "tip", "diff", 1));
        workoutRepository.add(new Workout("images/Tricep Raise.jpg", "nnnnnnnn", "desc", "tip", "diff", 1));
        workoutRepository.add(new Workout("images/Weighted Squat.jpg", "nnnnnnnn", "desc", "tip", "diff", 1));
        new Controller(queue, user, workoutRepository);
    }
}
