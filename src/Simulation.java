import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by terrence on 10/19/15.
 */
public class Simulation {
    public static void main(String args[]) throws Exception {

        final int defaultE = 16;
        // default elevator
        int numElevators = defaultE;
        ElevatorSystem es;

        numElevators = Integer.parseInt(args[0]);
        es = new ElevatorSystem(numElevators);

        Scanner scan;
        if (args.length > 1) {
            File f = new File(args[1]);
            scan = new Scanner(f);

            while(scan.hasNext()) {
                String line = scan.nextLine();
                if (line.equals("exit")) {
                    break;
                }
                else if (line.equals("state")) {
                    List<Elevator> elevators = es.state();

                    for (Elevator e : elevators) {
                        System.out.println(e.getState().toString());
                    }
                }
                else if (line.equals("step")) {
                    System.out.println("Elevator moving!");
                    es.step();
                }
                else if (line.contains("pickup")){
                    String[] pickup = line.split(" ");

                    System.out.println("Pick up request");
                    es.pickup(Integer.parseInt(pickup[1]), Integer.parseInt(pickup[2]));
                }
            }
        }
        else {
            scan = new Scanner(System.in);
            String line = scan.nextLine();
            while(!line.equals("exit")) {
                if (line.equals("state")) {
                    List<Elevator> elevators = es.state();

                    for (Elevator e : elevators) {
                        System.out.println(e.getState().toString());
                    }
                }
                else if (line.equals("step")) {
                    System.out.println("Elevator moving!");
                    es.step();
                }
                else if (line.contains("pickup")){
                    String[] pickup = line.split(" ");

                    System.out.println("Pick up request");
                    es.pickup(Integer.parseInt(pickup[1]), Integer.parseInt(pickup[2]));
                }
            }


        }

    }
}
