package Model;

import java.io.File;

public class Workout {
    private File image;
    private String title, description, tip, difficulty;
    private int duration, reps, sets;

    public Workout(File image, String title, String description, String tip, String difficulty) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.tip = tip;
        this.difficulty = difficulty;
        this.duration = 0;
        this.reps = 0;
    }

    public Workout(File image, String title, String description, String tip, String difficulty, int duration, int reps, int sets) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.tip = tip;
        this.difficulty = difficulty;
        this.duration = duration;
        this.reps = reps;
        this.sets = sets;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
