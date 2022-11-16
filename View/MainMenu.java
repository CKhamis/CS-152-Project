package View;

import Messages.Message;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;

public class MainMenu extends WorkoutViewer{
    // Page elements
    JTextField loginUsername;

    public MainMenu(BlockingQueue<Message> queue){
        super(queue);
        this.setTitle("Main Menu");

        // add elements to screen

        this.setVisible(true);
    }

    // Elements go here

}
