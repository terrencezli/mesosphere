import java.util.*;

/**
 * Created by terrence on 10/17/15.
 */


public class State {
    public int elevatorID;
    public int floorNum;
    public Queue<Integer> goalFloors;

    public State(int id, int fn) {
        elevatorID = id;
        floorNum = fn;

        // orders floors as added
        goalFloors = new PriorityQueue<Integer>();
    }

    public String toString() {
        return "Elevator ID: " + elevatorID + " Floor Number: " + floorNum +
                " Goal Floors: " + goalFloors.toString();
    }
}
