import java.util.List;

public class Elevator {
    public List<Passenger> passengers;
    private int currentFloor;
    private int destination;

    private Direction direction;

    public Elevator(int currentFloor, int destination, Direction direction, List<Passenger> passengers) {
        this.currentFloor = currentFloor;
        this.destination = destination;
        this.direction = direction;
        this.passengers = passengers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {

        return "Elevator{"
                + "  passengers=" + passengers.toString()
                + ", currentFloor=" + currentFloor
                + ", destination=" + destination
                + ", direction=" + direction
                + '}';
    }
}
