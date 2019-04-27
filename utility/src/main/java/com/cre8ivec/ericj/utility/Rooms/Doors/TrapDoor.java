package com.cre8ivec.ericj.utility.Rooms.Doors;

public class TrapDoor extends IDoor {
    @Override
    public Boolean isVisible() {
        return true;
    }

    @Override
    public Boolean canOpen() {
        return true;
    }

    @Override
    public IDoor returnDoor() {
        return null;
    }

    @Override
    public void openDoor() {

    }
}
