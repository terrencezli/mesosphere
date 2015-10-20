/**
 * Created by terrence on 10/15/15.
 */
import java.util.*;

public class Elevator {

    public State current;
    public Status currentStatus;

    public Elevator(int elevatorID) {
        // id and starts at floor 0
        current = new State(elevatorID, 0);
        currentStatus = Status.IDLE;
    }

    public State getState() {
        return current;
    }

    public void update(int goalFloor) {

        // dequeue if arrive on passenger floor method 1
        if (current.goalFloors.contains(current.floorNum)) {
            current.goalFloors.remove(current.floorNum);
            current.goalFloors.add(goalFloor);
        }

        /*
        method 2
        assume it's in the head node due to priority queue, better search?

        if (current.goalFloors.peek() == currentFloor) {
            current.goalFloors.poll();
        }
         */

        // reaches goal becomes idle
        if (current.goalFloors.isEmpty()) {
            currentStatus = Status.IDLE;
        }
        else {
            if (currentStatus == Status.DOWN) {
                current.floorNum--;
            }
            else if (currentStatus == Status.UP) {
                current.floorNum++;
            }
        }
        System.out.println("Elevator on floor " + current.floorNum);
    }

    public void addToQueue(int floor) {

        current.goalFloors.add(floor);

        if (currentStatus == Status.IDLE && floor > current.floorNum) {
            currentStatus = Status.UP;
        }
        else if (currentStatus == Status.IDLE && floor < current.floorNum) {
            currentStatus = Status.DOWN;
        }
    }
}
