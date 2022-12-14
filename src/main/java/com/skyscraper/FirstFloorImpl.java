package com.skyscraper;

import java.util.List;

public class FirstFloorImpl implements Floor {
    private boolean butonUp;
    private List<Passenger> passengerList;
    private int number;

    public FirstFloorImpl(boolean butonUp, List<Passenger> passengerList, int number) {
        this.butonUp = butonUp;
        this.passengerList = passengerList;
        this.number = number;
    }

    public boolean isButonUp() {
        return butonUp;
    }

    public void setButonUp(boolean butonUp) {
        this.butonUp = butonUp;
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
