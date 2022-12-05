package Controller;

import Messages.Message;
import Messages.ViewDetailsMessage;
import Model.UserData;
import Model.Workout;
import View.MainMenu;

import java.util.ArrayList;
import java.util.LinkedList;
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
        view = new MainMenu(queue, user, workouts);
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
