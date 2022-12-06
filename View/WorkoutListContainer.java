package View;

import Model.Workout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkoutListContainer extends JPanel implements ActionListener {
    private JButton viewDetailsButton;
    private JLabel image, title, difficulty;
    private Workout workout;
    private MainMenu view;
    public WorkoutListContainer(Workout workout, MainMenu mainMenu){
        setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        setLayout(new GridLayout(1, 4));
        this.view = mainMenu;
        this.workout = workout;
        title = new JLabel();
        title.setFont(new Font("Sans Serif", Font.BOLD, 20));
        image = new JLabel();
        difficulty = new JLabel();
        difficulty.setFont(new Font("Sans Serif", Font.BOLD, 20));
        viewDetailsButton = new JButton();
        viewDetailsButton.addActionListener(this);

        title.setText(workout.getTitle());
        difficulty.setText(workout.getDifficulty());
        updateIcon(workout);
        viewDetailsButton.setText("View Details");
        viewDetailsButton.setFont(new Font("Sans Serif", Font.BOLD, 20));

        add(image);
        add(title);
        add(difficulty);
        add(viewDetailsButton);
    }

    public static ImageIcon resizeImage(String path, int w, int h) {
        ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(w, h,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
    private void updateIcon(Workout workout) {
        ImageIcon icon;
        if(workout.getImage() != null) {
            icon = resizeImage(workout.getImage(), 100, 100);
        }else {
            icon = resizeImage("C:\\Users\\costi_dmi8dsd\\OneDrive\\Documents\\Projects\\Websites\\[IN]Grid Explorer\\img\\people\\No-image.png", 300, 300);
        }
        image.setIcon(icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == viewDetailsButton){
            view.updateWorkoutDetails(workout);
        }
    }
}
