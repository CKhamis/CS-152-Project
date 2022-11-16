package Controller;

import Messages.Message;
import View.MainMenu;
import View.WorkoutViewer;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Controller {
    private BlockingQueue<Message> queue;
    private List<Valve> valves;
    private WorkoutViewer view;

    public Controller(BlockingQueue<Message> queue){
        this.queue = queue;

        view = new MainMenu(queue);

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
