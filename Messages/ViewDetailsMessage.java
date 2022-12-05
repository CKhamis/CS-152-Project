package Messages;

import Model.Workout;

public class ViewDetailsMessage implements Message{
    private Workout workout;
    public ViewDetailsMessage(Workout workout){
        this.workout = workout;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
}
