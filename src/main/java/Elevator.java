import java.util.List;

public class Elevator {
    public List<Passenger> passengers;
    private int currentFloor;
    private int destination;

    private Directions directions;

    public Elevator(int currentFloor, int destination, Directions directions, List<Passenger> passengers) {
        this.currentFloor = currentFloor;
        this.destination = destination;
        this.directions = directions;
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

    public Directions getDirection() {
        return directions;
    }

    public void setDirection(Directions directions) {
        this.directions = directions;
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
                + ", direction=" + directions
                + '}';
    }
}
