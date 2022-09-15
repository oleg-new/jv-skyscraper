import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUMBER_OF_FLOOR = getRandomInt(5, 6);
    private static final int MAX_INDEX_FLOOR = NUMBER_OF_FLOOR -1;
    private static final int NUMBER_OF_PASSENGERS_PER_FLOOR = getRandomInt(0, 10);
    private static final Floor[] floorArray = new Floor[NUMBER_OF_FLOOR];

    public static void main(String[] args) {
        floorArray[0] = new FirstFloor(false,createListPassenger(1),1);
        for (int i = 1; i < MAX_INDEX_FLOOR; i++) {
            int floor = i + 1;
            floorArray[i] = new AverageFloor(false,false,createListPassenger(i + 1),i + 1);
        }
        floorArray[MAX_INDEX_FLOOR] =
                new LastFloor(false,createListPassenger(NUMBER_OF_FLOOR), NUMBER_OF_FLOOR);
        Elevator elevator = new Elevator(1, 1, Direction.UP, new ArrayList<>());
        int currentFloor = 1;
        while (true) {
            System.out.println(elevator);
            if (elevator.passengers.isEmpty() || elevator.passengers.size() < 5) {
                addPassengerToElevator(elevator,currentFloor);
            }
            pushButtonsUpDown();
            getNextFloor(elevator, currentFloor);
            elevator.setCurrentFloor(elevator.getDestination());
            goOut(elevator);
            System.out.println(elevator);
        }
    }

    private static int getRandomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
    private static int getRandomIntWithoutNumber(int min, int max, int number){
        int result;
        do {
            result = getRandomInt(min,max);
        } while (result == number);
        return result;
    }
    private static List<Passenger> createListPassenger(int curretFloor) {
        List<Passenger> currentList = new ArrayList<>();
        int f;
        for (int i = 0; i < NUMBER_OF_PASSENGERS_PER_FLOOR; i++) {
            currentList.add(new Passenger(getRandomIntWithoutNumber(1, NUMBER_OF_FLOOR,curretFloor)));
        }
        return currentList;
    }
    private static void addPassengerToElevator(Elevator elevator, int numberFloor){
        int iter = numberFloor - 1;
            for (int i = 0; i < floorArray[iter].getPassengerList().size(); i++){
                if (elevator.getDirection() == Direction.UP && floorArray[iter].getPassengerList().get(i).getDestination() > numberFloor){
                    elevator.passengers.add(floorArray[iter].getPassengerList().get(i));
                    floorArray[iter].getPassengerList().remove(i);
                    floorArray[iter].setButonUp(false);
                    if (elevator.passengers.size() == 5){
                        return;
                    }
                }
                if (elevator.getDirection() == Direction.DOWN && floorArray[numberFloor].getPassengerList().get(i).getDestination() < numberFloor ){
                    elevator.passengers.add(floorArray[numberFloor].getPassengerList().get(i));
                    floorArray[iter].getPassengerList().remove(i);
                    floorArray[iter].setButonDown(false);
                    if (elevator.passengers.size() == 5){
                        return;
                    }
                }
            }
    }
    private static void getNextFloor(Elevator elevator, int numberFloor) {
        while (elevator.getCurrentFloor() == elevator.getDestination()) {
            int destination;
            if (elevator.getDirection() == Direction.UP) {
                destination = NUMBER_OF_FLOOR +1;
                for (Passenger current : elevator.passengers) {
                    if (current.getDestination() > numberFloor && current.getDestination() < destination) {
                        destination = current.getDestination();
                    }
                }
                if ( destination == NUMBER_OF_FLOOR +1 || elevator.passengers.size() < 5) {
                    destination = getPressedButtonUp(numberFloor);
                    if ( destination == NUMBER_OF_FLOOR +1){
                        elevator.setDirection(Direction.DOWN);
                    }
                } else {
                    elevator.setDestination(destination);
                }

            }
            if (elevator.getDirection() == Direction.DOWN){
                destination = 0;
                for (Passenger current : elevator.passengers) {
                    if (current.getDestination() < numberFloor && current.getDestination() > destination) {
                        destination = current.getDestination();
                    }
                }
                if(destination == 0 || elevator.passengers.size() < 5){
                    destination = getPressedButtonDown(numberFloor);
                    if (destination == 0){
                        elevator.setDirection(Direction.UP);
                    }
                }else {
                    elevator.setDestination(destination);
                }
            }
        }
    }
    private static int getPressedButtonUp(int numberFloor){
        int result = NUMBER_OF_FLOOR + 1;
        for (int i = numberFloor -1; i < NUMBER_OF_FLOOR; i++){
            if (floorArray[i].isButonUp()){
                if (i < result){
                    result = i;
                }
            }
        }
        return result;
    }
    private static int getPressedButtonDown(int numberFloor){
        int result = 0;
        for (int i = numberFloor-1; i > 0; i--){
            if (floorArray[i].isButonDown()){
                if (i > result){
                    result = i;
                }
            }
        }
        return result;
    }
    private static void pushButtonsUpDown() {
        for (Floor currentFloor : floorArray) {
            for (Passenger currentPassenger : currentFloor.getPassengerList()) {
                if (currentPassenger.getDestination() > currentFloor.getNumber()) {
                    currentFloor.setButonUp(true);
                }
                if (currentPassenger.getDestination() < currentFloor.getNumber()) {
                    currentFloor.setButonDown(true);
                }
            }
        }
    }
    private static void goOut(Elevator elevator){
        int currentFloor = elevator.getCurrentFloor();
        int leg = elevator.passengers.size();
        for (int i = 0; i < leg; i++){
            if (elevator.passengers.get(i).getDestination() == currentFloor) {
                elevator.passengers.get(i).setDestination(getRandomIntWithoutNumber(1, NUMBER_OF_FLOOR, currentFloor));
                floorArray[currentFloor - 1].getPassengerList().add(elevator.passengers.get(i));
                elevator.passengers.remove(i);
            }
        }
        /*for (Passenger currentPassenger: elevator.getPassengers()){
            if (currentPassenger.getDestination() == currentFloor){
                floorArray[currentFloor - 1].getPassengerList().add(currentPassenger);
                elevator.passengers.remove(currentPassenger);
                currentPassenger.setDestination(getRandomIntWithoutNumber(1, NUMBER_OF_FLOOR, currentFloor));
            }
        }*/


    }
}
