package View;

import Messages.Message;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class WorkoutViewer extends JFrame{
    BlockingQueue<Message> queue;
    JPanel topPanel;

    public WorkoutViewer(BlockingQueue<Message> queue){
        this.queue = queue;

        //Initializes main JFrame
        this.getContentPane().setBackground(new Color(7, 43, 120));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());

        // Creates a panel across the top of the frame and sets its size
        topPanel = new JPanel();
        topPanel.setBounds(0, 0, this.getWidth(), this.getHeight() / 6);
        topPanel.setSize(this.getWidth(), this.getHeight() / 6);
        topPanel.setLayout(null);
        topPanel.setBackground(new Color(160, 212, 226));
        topPanel.setVisible(true);

        // adds the topPanel to the JFrame
        this.add(topPanel);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
