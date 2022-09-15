import java.util.List;

public class AverageFloor implements Floor {
    private boolean butonUp;
    private boolean butonDown;
    private List<Passenger> passengerList;
    private int number;

    public AverageFloor(boolean butonUp, boolean butonDown, List<Passenger> passengerList, int number) {
        this.butonUp = butonUp;
        this.butonDown = butonDown;
        this.passengerList = passengerList;
        this.number = number;
    }

    public boolean isButonUp() {
        return butonUp;
    }

    public void setButonUp(boolean butonUp) {
        this.butonUp = butonUp;
    }

    public boolean isButonDown() {
        return butonDown;
    }

    public void setButonDown(boolean butonDown) {
        this.butonDown = butonDown;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
