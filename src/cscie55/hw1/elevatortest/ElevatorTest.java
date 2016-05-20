package cscie55.hw1.elevatortest;

import cscie55.hw1.elevator.Elevator;
/**
 * @Author ssurabhi on 9/13/15.
 * @version 1.0
 */
public class ElevatorTest {

    /*
    @Param args
     */
    public static void main(String args[]){
         /*Move Elevator from the ground floor to the top floor, and then back to the ground floor.
        That means to go to the 7th floor from ground floor 6 moves required. Similar way to move from top floor to ground floor,
        6 moves required. Total 12 moves.
         */
        int numberOfMovesRequired = 12;

        /* Creating an elevator object*/
        Elevator elevator = new Elevator();

        /* Board 3 passengers for the third floor */
        elevator.boardPassenger(3);
        elevator.boardPassenger(3);

        /*Board 1 passenger for the 5th floor*/
        elevator.boardPassenger(5);

        /*Printing state of the elevator before first move */
        System.out.println(elevator);


        /*Need to call move() method 12 times*/
        for(int i = 1; i <= numberOfMovesRequired; i++){
            elevator.move();
            /* printing the state of the elevator after each move */
            System.out.println(elevator);
        }
    }

}
