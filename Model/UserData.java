package Model;

import java.util.ArrayList;

public class UserData {
    private ArrayList<Playlist> workoutPlaylists;

    public UserData() {
        this.workoutPlaylists = new ArrayList<>();
    }

    public UserData(String name) {
        this.workoutPlaylists = new ArrayList<>();
    }

    public ArrayList<Playlist> getWorkoutPlaylists() {
        return workoutPlaylists;
    }

    public void setWorkoutPlaylists(ArrayList<Playlist> workoutPlaylists) {
        this.workoutPlaylists = workoutPlaylists;
    }
}
