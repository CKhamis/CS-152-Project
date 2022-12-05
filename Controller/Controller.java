package Controller;

import Messages.Message;
import Model.UserData;
import Model.Workout;
import View.MainMenu;
import View.WorkoutViewer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Controller {
    private BlockingQueue<Message> queue;
    private List<Valve> valves;
    private MainMenu view;
    private ArrayList<Workout> workoutRepository;

    public Controller(BlockingQueue<Message> queue, UserData user, ArrayList<Workout> workouts){
        this.queue = queue;
        this.workoutRepository = workouts;
        Workout init = workouts.get(0);
        view = new MainMenu(queue, user, init);
        view.frame.setVisible(true);

        //Valves

        mainLoop();
    }

    public void mainLoop(){
        ValveMessage response = ValveMessage.EXECUTED;
        Message message = null;

        while (response != ValveMessage.FINISH) {
            try {
                message = queue.take();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (Valve valve : valves) {
                response = valve.execute(message);
                if (response != ValveMessage.MISS) {
                    break;
                }
            }
        }
    }

    private interface Valve {
        /**
         * Performs operation, returns enum
         */
        public ValveMessage execute(Message message);
    }
}
