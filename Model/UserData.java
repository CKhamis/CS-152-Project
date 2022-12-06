package Model;

import java.util.ArrayList;

public class UserData extends ArrayList<Playlist>{
    private ArrayList<Playlist> workoutPlaylists;

    public UserData() {
        this.workoutPlaylists = new ArrayList<>();
    }

    public UserData(String name) {
        this.workoutPlaylists = new ArrayList<>();
    }
}
