package View;

import Messages.Message;
import Model.Exercise;
import Model.Playlist;
import Model.UserData;
import Model.Workout;
import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.border.Border;
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
    private static final String DEFAULT_TITLE = "Cool Playlist";
    public JFrame frame;
    BlockingQueue<Message> queue;
    UserData user;
    private JToggleButton newPlaylist, viewWorkouts, viewPlaylists;
    private JPanel bodyContainer, viewWorkoutsPanel, workoutListContainer, workoutList, viewPlaylistsPanel, newPlaylistsPanel, playlistWorkoutListContainer, playlistWorkoutList;
    private JButton addWorkoutToPlaylist, savePlaylist;
    private JTextField playlistName;
    private Workout currentWorkout;
    private ArrayList<Workout> workoutRepository;
    private JLabel workoutIcon, workoutTitle, workoutDescription, workoutDifficulty, workoutDuration, workoutTip;
    private String[] workoutNameList;
    private ArrayList<ExerciseContainer> listExercises;

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
        viewWorkoutsPanel.setBackground(COLOR_BODY);
        bodyContainer.add(viewWorkoutsPanel, "viewWorkouts");
        viewWorkoutsPanel.setLayout(new BorderLayout(0, 0));

        // Set up details panel
        JPanel detailPanel = new JPanel();
        detailPanel.setBackground(COLOR_SECONDARY);
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
        bodyContainer.add(newPlaylistsPanel, "newPlaylist");
        newPlaylistsPanel.setLayout(new BorderLayout(0, 0));

        //Set up action menu
        JPanel playlistActionPane = new JPanel();
        playlistActionPane.setBackground(COLOR_SECONDARY);
        playlistActionPane.setLayout(new BorderLayout(0, 0));
        newPlaylistsPanel.add(playlistActionPane, BorderLayout.NORTH);

        //Set up right button container
        JPanel newPlaylistActionGroup = new JPanel();
        newPlaylistActionGroup.setBackground(COLOR_SECONDARY);
        playlistActionPane.add(newPlaylistActionGroup, BorderLayout.EAST);

        addWorkoutToPlaylist = new JButton("Add Workout");
        savePlaylist = new JButton("Save as New Playlist");

        addWorkoutToPlaylist.addActionListener(this);
        savePlaylist.addActionListener(this);

        newPlaylistActionGroup.add(addWorkoutToPlaylist);
        newPlaylistActionGroup.add(savePlaylist);

        //Set up left playlist container
        JPanel newPlaylistNameGroup = new JPanel();
        newPlaylistNameGroup.setBackground(COLOR_SECONDARY);
        playlistActionPane.add(newPlaylistNameGroup, BorderLayout.WEST);

        JLabel playlistTitle = new JLabel();
        playlistTitle.setText("Playlist Name: ");
        playlistTitle.setFont(new Font("Sans Serif", Font.BOLD, 20));
        newPlaylistNameGroup.add(playlistTitle);

        playlistName = new JTextField();
        playlistName.setColumns(10);
        playlistName.setText(DEFAULT_TITLE);
        newPlaylistNameGroup.add(playlistName);

        //Set up where workouts will populate
        playlistWorkoutListContainer = new JPanel();
        playlistWorkoutListContainer.setBackground(newPlaylistsPanel.getBackground());
        newPlaylistsPanel.add(playlistWorkoutListContainer, BorderLayout.CENTER);
        playlistWorkoutListContainer.setLayout(new GridLayout(0, 1, 0, 0));

        playlistWorkoutList = new JPanel();
        playlistWorkoutList.setBackground(playlistWorkoutListContainer.getBackground());
        playlistWorkoutList.setLayout(new GridLayout(0, 1, 10, 5));

        JScrollPane playlistWorkoutScrollPane = new JScrollPane(playlistWorkoutList);
        playlistWorkoutScrollPane.setBackground(playlistWorkoutListContainer.getBackground());
        playlistWorkoutScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        playlistWorkoutScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        playlistWorkoutScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        playlistWorkoutListContainer.add(playlistWorkoutScrollPane);

        //Set up options
        workoutNameList = new String[workoutRepository.size()];
        for(int i = 0; i < workoutRepository.size(); i++){
            workoutNameList[i] = workoutRepository.get(i).getTitle();
        }
        listExercises = new ArrayList<>();

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
        } else if(e.getSource() == addWorkoutToPlaylist){
            ExerciseContainer exerciseContainer = new ExerciseContainer(workoutNameList, listExercises.size()+1);
            listExercises.add(exerciseContainer);
            playlistWorkoutList.add(exerciseContainer);
            playlistWorkoutList.revalidate();
            playlistWorkoutList.repaint();
        }else if(e.getSource() == savePlaylist){
            // Generate list of exercises from the list of exercise containers
            Playlist ret = new Playlist(playlistName.getText());
            for(ExerciseContainer container : listExercises){
                ret.add(new Exercise(workoutRepository.get(container.getWorkout()), container.getSets(), container.getReps()));
            }

            //Save to user list
            user.addWorkoutPlaylist(ret);

            //Reset the playlist maker
            playlistName.setText(DEFAULT_TITLE);
            listExercises.removeAll(listExercises);
            playlistWorkoutList.removeAll();
            playlistWorkoutList.revalidate();
            playlistWorkoutList.repaint();
        }
    }
}
