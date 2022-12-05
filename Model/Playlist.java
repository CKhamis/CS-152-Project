package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Playlist extends ArrayList<Workout> {
    private String name;
    private LocalDateTime created;

    public Playlist(String name) {
        this.name = name;
        this.created = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public int getTotalDuration(){
        int sum = 0;
        for(Workout w : this){
            sum += w.getDuration() * w.getReps() * w.getSets();
        }
        return sum;
    }
    public int getTotalUniqueWorkouts(){
        return super.size();
    }
    public int getTotalReps(){
        int sum = 0;
        for(Workout w : this){
            sum += w.getReps() * w.getSets();
        }
        return sum;
    }
}
