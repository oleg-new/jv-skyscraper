package com.skyscraper;

import java.util.List;

public interface Floor {
    public List<Passenger> passengerList = null;
    int number = 0;
    boolean butonUp = false;
    boolean butonDown = false;
    default boolean isButonUp() {
        return false;
    }

    default void setButonUp(boolean butonUp) {

    }

    default boolean isButonDown() {
        return false;
    }

    default void setButonDown(boolean butonDown) {

    }

    default List<Passenger> getPassengerList() {
        return null;
    }

    default void setPassengerList(List<Passenger> passengerList) {

    }

    default int getNumber() {
        return 0;
    }

    default void setNumber(int number) {

    }

}
