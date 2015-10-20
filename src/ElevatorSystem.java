import java.util.*;

/**
 * Created by terrence on 10/17/15.
 */
public class ElevatorSystem {
    List<Elevator> elevators;
    Queue<Requests> pickUpRequests;

    public ElevatorSystem(int numElevators) {
        elevators = new ArrayList<Elevator>(numElevators);
        pickUpRequests = new LinkedList<Requests>();

        // set up id's
        for (int i = 0; i < numElevators; i++) {
            // id = index
            elevators.add(new Elevator(i));
        }
    }

    public List<Elevator> state() {
        return elevators;
    }

    public void pickup(int floor, int direction) {
        /*
        pick up only if it's in the same direction
        and greater or less than current floor depending on direction
        but make sure no elevator is idle first
         */
        boolean idle = false;
        for (Elevator e : elevators) {
            if (e.currentStatus == Status.IDLE) {
                System.out.println("Idle elevator " + e.getState().elevatorID + " picking up " + floor);
                e.addToQueue(floor);
                idle = true;
                break;
            }
        }

        if (!idle) {
            for (Elevator e : elevators) {
                if (direction < 0 && e.currentStatus == Status.DOWN && e.current.floorNum > floor) {
                    System.out.println("Elevator " + e.getState().elevatorID + " picking up " + floor + "on the way down");
                    e.addToQueue(floor);
                    break;
                }
                else if (direction > 0 && e.currentStatus == Status.UP && e.current.floorNum < floor) {
                    System.out.println("Elevator " + e.getState().elevatorID + " picking up " + floor + "on the way up");
                    e.addToQueue(floor);
                    break;
                }
            }
        }
    }

    // there is a helper function in elevator class
    public void update(int elevatorID) {
        elevators.get(elevatorID).update();
    }

    public void step() {
        for (Elevator e : elevators) {
            if (!pickUpRequests.isEmpty()) {
                Requests requested = pickUpRequests.poll();

                pickup(requested.floor, requested.direction);

            }

            update(e.current.elevatorID);
        }
    }
}
