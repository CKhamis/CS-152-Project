package Model;

public class Exercise extends Workout{
    int sets, reps;

    public Exercise(String image, String title, String description, String tip, String difficulty, int duration, int sets, int reps) {
        super(image, title, description, tip, difficulty, duration);
        this.sets = sets;
        this.reps = reps;
    }

    public Exercise(Workout workout, int sets, int reps){
        super(workout.getImage(), workout.getTitle(), workout.getDescription(), workout.getTip(), workout.getDifficulty(), workout.getDuration());
        this.sets = sets;
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
