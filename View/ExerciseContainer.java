package View;

import Model.Exercise;
import Model.Workout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ExerciseContainer extends JPanel implements ActionListener {
    private JComboBox<String> workoutPicker;
    private JTextField reps, sets;

    public ExerciseContainer(String[] options, int index){
        this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        this.setLayout(new GridLayout(1, 4));

        JLabel workoutNumber = new JLabel();
        workoutNumber.setText("Exercise #" + index);
        workoutNumber.setFont(new Font("San Serif", Font.BOLD, 20));
        this.add(workoutNumber);

        JPanel firstGroup = new JPanel();
        firstGroup.setLayout(new GridLayout(2, 1));
        this.add(firstGroup);

        workoutPicker = new JComboBox<>();
        workoutPicker.setModel(new DefaultComboBoxModel<>(options));
        JLabel choseWorkoutLabel = new JLabel();
        choseWorkoutLabel.setFont(new Font("San Serif", Font.PLAIN, 18));
        choseWorkoutLabel.setHorizontalAlignment(SwingConstants.CENTER);
        choseWorkoutLabel.setText("Chose Workout");
        firstGroup.add(choseWorkoutLabel);
        firstGroup.add(workoutPicker);

        JPanel secondGroup = new JPanel();
        secondGroup.setLayout(new GridLayout(2, 1));
        this.add(secondGroup);

        reps = new JTextField();
        reps.setText("1");
        reps.setColumns(10);
        reps.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel choseSetsLabel = new JLabel();
        choseSetsLabel.setText("Chose Sets");
        choseSetsLabel.setFont(new Font("San Serif", Font.PLAIN, 18));
        secondGroup.add(choseSetsLabel);
        secondGroup.add(reps);

        JPanel thirdGroup = new JPanel();
        thirdGroup.setLayout(new GridLayout(2, 1));
        this.add(thirdGroup);

        sets = new JTextField();
        sets.setText("1");
        sets.setColumns(10);
        sets.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel choseRepsLabel = new JLabel();
        choseRepsLabel.setText("Chose Reps");
        choseRepsLabel.setFont(new Font("San Serif", Font.PLAIN, 18));
        thirdGroup.add(choseRepsLabel);
        thirdGroup.add(sets);
    }

    public int getReps(){
        return Integer.valueOf(this.reps.getText());
    }
    public int getSets(){
        return Integer.valueOf(this.sets.getText());
    }
    public int getWorkout(){
        return workoutPicker.getSelectedIndex();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
