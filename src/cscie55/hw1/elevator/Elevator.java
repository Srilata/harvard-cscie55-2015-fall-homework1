package cscie55.hw1.elevator;

/**
 * @Author ssurabhi on 9/13/15.
 * @version 1.0
 */

public class Elevator {

    /*
    As array counts index from 0, and we are counting floors from 1.
     To avoid confusion declaring array size as 8(7+1) and initializing them to false.
     Same logic applied for passengerCountPerFloor. So initialized them to zeros
     stopFlagArray flag shows weather stop required for a particular floor*/
    private boolean stopFlagArray[] = {false,false,false,false,false,false,false,false};
    /* Number of passengers destined for the floor*/
    private int passengerCountPerFloor[]={0,0,0,0,0,0,0,0};
    private int onBoardPassengerCount = 0;
    private static final int NUMBER_OF_FLOORS = 7;
    private int currentFloor = 1;
    Direction direction = Direction.UP;

    /* This is a default constructor.No need to declare. To satisfy the home work requirement declared one.
      The class should have a no-argument constructor that sets up the elevator's state.
      */
    public Elevator(){

    }

    /*
       Takes the floor as parameter. This method adds to the elevator a passenger destined for the indicated floor
       and enables the stopFlagArray if any passengers destined to that floor.
    @Param floor
     */
    public void boardPassenger(int floor){
        onBoardPassengerCount++;
        passengerCountPerFloor[floor]++;
        stopFlagArray[floor] = true;
    }

    /*
       This method modifies the Elevator state
       Modifies the current floor
       Modifies the direction of travel, if the ground floor or top floor has been reached
      Clears the array entry tracking the number of passengers destined for the floor that the elevator has just arrived at.
      Clears the array entry indicating that a stop is required on the floor that the elevator has just arrived at
      @param
     */
    public void move(){

        if(direction.equals(Direction.UP)) {
            currentFloor ++;
        }

        if(direction.equals(Direction.DOWN)) {
            currentFloor --;
        }

        if(currentFloor == 1){
            direction = Direction.UP;
        }

        if(currentFloor == NUMBER_OF_FLOORS){
            direction = Direction.DOWN;
        }

        if(stopFlagArray[currentFloor]==true){
            onBoardPassengerCount = onBoardPassengerCount - passengerCountPerFloor[currentFloor];
            passengerCountPerFloor[currentFloor] = 0;
            stopFlagArray[currentFloor] = false;
        }
    }

    /*
    It overrides the toString method
    @return string with Floor and passenger information
    */

    public String toString(){
        if(onBoardPassengerCount ==1){
            return "Floor "+currentFloor+": "+onBoardPassengerCount+" passenger";
        }
        return "Floor "+currentFloor+": "+onBoardPassengerCount+" passengers";
    }
}
