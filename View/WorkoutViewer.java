package View;

import Messages.MainMenuMessage;
import Messages.Message;
import Messages.NewWorkoutMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.BlockingQueue;

public class WorkoutViewer extends JFrame{
    BlockingQueue<Message> queue;
    JPanel topPanel;
    JLabel programName;

    public WorkoutViewer(BlockingQueue<Message> queue){
        this.queue = queue;

        //Initializes main JFrame
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());

        // Creates a panel across the top of the frame and sets its size
        topPanel = new JPanel();
        topPanel.setBounds(0, 0, this.getWidth(), this.getHeight() / 10);
        topPanel.setSize(this.getWidth(), this.getHeight() / 10);
        topPanel.setLayout(null);

        // Creates a JLabel for the program name
        programName = new JLabel("Workout Buddy");
        programName.setFont(new Font("Sans Serif", Font.BOLD, 60));
        programName.setBounds(this.getX() + 30, this.getY() - 90, this.getWidth() / 4, this.getHeight() / 6);
        programName.setForeground(Color.WHITE);
        programName.setHorizontalAlignment(SwingConstants.LEFT);
        programName.setVerticalAlignment(SwingConstants.BOTTOM);
        programName.setVisible(true);

        // adds the title to the top panel
        topPanel.add(programName);
        topPanel.setBackground(new Color(160, 212, 226));
        topPanel.setVisible(true);

        // adds the topPanel to the JFrame
        this.add(topPanel);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addHomeActionListener() {
        programName.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    Message msg = new MainMenuMessage();
                    queue.put(msg);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    public void addWorkoutButton() {
        // Creates a JLabel for the create workout button
        JLabel addWorkout = new JLabel("+");
        addWorkout.setFont(new Font("Sans Serif", Font.BOLD, 60));
        addWorkout.setBounds(3 * (this.getWidth() / 4), this.getY() - 90, (this.getWidth() / 4) - 30, this.getHeight() / 6);
        addWorkout.setBackground(new Color(160, 212, 226));
        addWorkout.setForeground(Color.WHITE);
        addWorkout.setHorizontalAlignment(SwingConstants.RIGHT);
        addWorkout.setVerticalAlignment(SwingConstants.BOTTOM);
        addWorkout.setVisible(true);

        // adds an action listener prompting the user to sign out
        addWorkout.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    Message msg = new NewWorkoutMessage();
                    queue.put(msg);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        });

        // adds the JLabel to the topPanel
        topPanel.add(addWorkout);
    }
}
