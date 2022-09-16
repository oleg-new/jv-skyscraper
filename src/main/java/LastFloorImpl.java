import java.util.List;

public class LastFloorImpl implements Floor {
    private boolean butonDown;
    private List<Passenger> passengerList;
    private int number;

    public LastFloorImpl(boolean butonDown, List<Passenger> passengerList, int number) {
        this.butonDown = butonDown;
        this.passengerList = passengerList;
        this.number = number;
    }

    @Override
    public boolean isButonDown() {
        return butonDown;
    }

    @Override
    public void setButonDown(boolean butonDown) {
        this.butonDown = butonDown;
    }

    @Override
    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    @Override
    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }
}
