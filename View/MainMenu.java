package View;

import Messages.Message;
import Model.UserData;
import Model.Workout;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class MainMenu implements ActionListener {
    private static final Color COLOR_SECONDARY = new Color(180, 180, 180);
    private static final Color COLOR_HEADER = Color.WHITE;
    private static final Color COLOR_BODY = new Color(240, 240, 240);
    private static final String APPLICATION_NAME = "Workout Buddy";
    public JFrame frame;
    BlockingQueue<Message> queue;
    UserData user;
    private JToggleButton newPlaylist, viewWorkouts, viewPlaylists;
    private JPanel bodyContainer, viewWorkoutsPanel, workoutListContainer, workoutList, viewPlaylistsPanel, newPlaylistsPanel;

    private Workout currentWorkout;
    private ArrayList<Workout> workoutRepository;
    private JLabel workoutIcon, workoutTitle, workoutDescription, workoutDifficulty, workoutDuration, workoutTip;

    public MainMenu(BlockingQueue<Message> queue, UserData userData, ArrayList<Workout> workouts){
        this.queue = queue;
        this.user = userData;
        this.workoutRepository = workouts;
        initialize();
        updateWorkoutDetails(workouts.get(0));
    }
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Sans Serif", Font.BOLD, 30));

        // Set up the top panel
        JPanel headerContainer = new JPanel();
        headerContainer.setBackground(COLOR_HEADER);
        frame.getContentPane().add(headerContainer, BorderLayout.NORTH);
        headerContainer.setLayout(new BorderLayout(0, 0));

        // Set up the top panel left nav container
        JPanel leftHeaderContainer = new JPanel();
        leftHeaderContainer.setBackground(COLOR_HEADER);
        FlowLayout flowLayout = (FlowLayout) leftHeaderContainer.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        headerContainer.add(leftHeaderContainer, BorderLayout.WEST);

        JPanel leftHeaderGroup = new JPanel();
        leftHeaderGroup.setBackground(COLOR_HEADER);
        leftHeaderContainer.add(leftHeaderGroup);

        //Set up title
        JLabel TitleText = new JLabel(APPLICATION_NAME);
        TitleText.setBackground(COLOR_HEADER);
        TitleText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        leftHeaderGroup.add(TitleText);

        //Set up top panel right nav container
        JPanel rightHeaderContainer = new JPanel();
        rightHeaderContainer.setBackground(COLOR_HEADER);
        FlowLayout flowLayout_1 = (FlowLayout) rightHeaderContainer.getLayout();
        flowLayout_1.setAlignment(FlowLayout.RIGHT);
        headerContainer.add(rightHeaderContainer, BorderLayout.EAST);

        //Set up a container within the right side of the right nav container
        JPanel fileActionsGroup = new JPanel();
        fileActionsGroup.setBackground(COLOR_HEADER);
        rightHeaderContainer.add(fileActionsGroup);

        newPlaylist = new JToggleButton("New Playlist");
        newPlaylist.setFont(new Font("Sans Serif", Font.BOLD, 25));
        fileActionsGroup.add(newPlaylist);
        newPlaylist.addActionListener(this);
        viewPlaylists = new JToggleButton("View Playlists");
        viewPlaylists.setFont(new Font("Sans Serif", Font.BOLD, 25));
        fileActionsGroup.add(viewPlaylists);
        viewPlaylists.addActionListener(this);
        viewWorkouts = new JToggleButton("View Workouts");
        viewWorkouts.setFont(new Font("Sans Serif", Font.BOLD, 25));
        fileActionsGroup.add(viewWorkouts);
        viewWorkouts.addActionListener(this);

        //Set up body
        bodyContainer = new JPanel();
        frame.getContentPane().add(bodyContainer, BorderLayout.CENTER);
        bodyContainer.setLayout(new CardLayout(0,0));

        //Set up View Workouts screen
        viewWorkoutsPanel = new JPanel();
        viewWorkoutsPanel.setBackground(Color.green);
        bodyContainer.add(viewWorkoutsPanel, "viewWorkouts");
        viewWorkoutsPanel.setLayout(new BorderLayout(0, 0));

        // Set up details panel
        JPanel detailPanel = new JPanel();
        detailPanel.setBackground(Color.red);
        detailPanel.setLayout(new GridLayout(6, 0, 0, 0));

        workoutIcon = new JLabel();
        workoutIcon.setMinimumSize(new Dimension(300, 300));
        detailPanel.add(workoutIcon);

        workoutTitle = new JLabel();
        workoutTitle.setFont(new Font("Sans Serif", Font.BOLD, 30));
        workoutTitle.setHorizontalAlignment(SwingConstants.CENTER);
        detailPanel.add(workoutTitle);
        workoutDescription = new JLabel();
        workoutDescription.setFont(new Font("Sans Serif", Font.BOLD, 20));
        workoutDescription.setHorizontalAlignment(SwingConstants.CENTER);
        detailPanel.add(workoutDescription);
        workoutDifficulty = new JLabel();
        workoutDifficulty.setFont(new Font("Sans Serif", Font.BOLD, 20));
        workoutDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
        detailPanel.add(workoutDifficulty);
        workoutTip = new JLabel();
        workoutTip.setFont(new Font("Sans Serif", Font.BOLD, 20));
        workoutTip.setHorizontalAlignment(SwingConstants.CENTER);
        detailPanel.add(workoutTip);
        workoutDuration = new JLabel();
        workoutDuration.setFont(new Font("Sans Serif", Font.BOLD, 15));
        workoutDuration.setHorizontalAlignment(SwingConstants.CENTER);
        detailPanel.add(workoutDuration);

        viewWorkoutsPanel.add(detailPanel, BorderLayout.WEST);

        // Set up list of workouts
        workoutListContainer = new JPanel();
        workoutListContainer.setBackground(viewWorkoutsPanel.getBackground());
        viewWorkoutsPanel.add(workoutListContainer, BorderLayout.CENTER);
        workoutListContainer.setLayout(new GridLayout(0, 1, 0, 0));

        workoutList = new JPanel();
        workoutList.setBackground(workoutListContainer.getBackground());
        workoutList.setLayout(new GridLayout(0, 1, 10, 5));

        JScrollPane workoutScrollPane = new JScrollPane(workoutList);
        workoutScrollPane.setBackground(workoutListContainer.getBackground());
        workoutScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        workoutScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        workoutScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        workoutListContainer.add(workoutScrollPane);

        //Set up View Playlist screen
        viewPlaylistsPanel = new JPanel();
        viewPlaylistsPanel.setBackground(Color.black);
        bodyContainer.add(viewPlaylistsPanel, "viewPlaylists");
        viewPlaylistsPanel.setLayout(new BorderLayout(0, 0));

        //Set up New Playlist screen
        newPlaylistsPanel = new JPanel();
        newPlaylistsPanel.setBackground(Color.orange);
        bodyContainer.add(newPlaylistsPanel, "newPlaylist");
        newPlaylistsPanel.setLayout(new BorderLayout(0, 0));


        viewWorkouts.setSelected(true);
        frame.setBounds(100, 100, 1378, 788);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateWorkoutDetails(Workout workout){
        this.currentWorkout = workout;

        workoutTitle.setText(workout.getTitle());
        workoutDescription.setText(workout.getDescription());
        workoutDifficulty.setText(workout.getDifficulty());
        workoutDuration.setText(workout.getDuration() + "sec");
        workoutTip.setText(workout.getTip());
        updateIcon(workout.getImage());

        workoutList.removeAll();

        for(Workout m : workoutRepository) {
            WorkoutListContainer n = new WorkoutListContainer(m, this);
            workoutList.add(n);
        }
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
        if(currentWorkout.getImage() != null) {
            icon = resizeImage(path, 300, 300);
        }else {
            icon = resizeImage("C:\\Users\\costi_dmi8dsd\\OneDrive\\Documents\\Projects\\Websites\\[IN]Grid Explorer\\img\\people\\No-image.png", 300, 300);
        }
        workoutIcon.setIcon(icon);
    }

    private void setCurrentTabSelection(JToggleButton button) {
        viewWorkouts.setSelected(false);
        viewPlaylists.setSelected(false);
        newPlaylist.setSelected(false);
        button.setSelected(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewWorkouts) {
            setCurrentTabSelection(viewWorkouts);
            CardLayout cl = (CardLayout)(bodyContainer.getLayout());
            cl.show(bodyContainer, "viewWorkouts");
        } else if (e.getSource() == viewPlaylists) {
            setCurrentTabSelection(viewPlaylists);
            CardLayout cl = (CardLayout)(bodyContainer.getLayout());
            cl.show(bodyContainer, "viewPlaylists");
        } else if (e.getSource() == newPlaylist) {
            setCurrentTabSelection(newPlaylist);
            CardLayout cl = (CardLayout)(bodyContainer.getLayout());
            cl.show(bodyContainer, "newPlaylist");
        }
    }
}
