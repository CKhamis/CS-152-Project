package View;

import Model.Exercise;
import Model.Workout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ViewExerciseContainer extends JPanel {
    private JLabel image;
    public ViewExerciseContainer(Exercise exercise, int index){
        setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        setLayout(new GridLayout(1, 5)); //image, Exercise num, Exercise name, #sets, #reps

        image = new JLabel();
        JLabel exerciseNum = new JLabel();
        JLabel exerciseName = new JLabel();
        JLabel sets = new JLabel();
        JLabel reps = new JLabel();

        exerciseNum.setText("Exercise #" + index);
        exerciseNum.setFont(new Font("San Serif", Font.BOLD, 20));
        exerciseName.setText(exercise.getTitle());
        exerciseName.setFont(new Font("San Serif", Font.BOLD, 20));
        sets.setText("Sets: " + exercise.getSets());
        sets.setFont(new Font("San Serif", Font.BOLD, 20));
        reps.setText("Reps: " + exercise.getReps());
        reps.setFont(new Font("San Serif", Font.BOLD, 20));
        updateIcon(exercise.getImage());

        add(image);
        add(exerciseNum);
        add(exerciseName);
        add(sets);
        add(reps);
    }

    public static ImageIcon resizeImage(String path, int w, int h) {
        ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(w, h,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
    private void updateIcon(String path) {
        ImageIcon icon;
        if(path != null) {
            icon = resizeImage(path, 100, 100);
        }else {
            icon = resizeImage("C:\\Users\\costi_dmi8dsd\\OneDrive\\Documents\\Projects\\Websites\\[IN]Grid Explorer\\img\\people\\No-image.png", 300, 300);
        }
        image.setIcon(icon);
    }
}
