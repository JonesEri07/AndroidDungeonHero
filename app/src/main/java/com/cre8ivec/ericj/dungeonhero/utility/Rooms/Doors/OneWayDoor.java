package com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors;

public class OneWayDoor extends IDoor {

    public OneWayDoor() {
        visibility = true;
        openable = true;
    }
    @Override
    public Boolean isVisible() {
        return visibility;
    }

    @Override
    public Boolean canOpen() {
        return openable;
    }

    @Override
    public IDoor returnDoor() {
        return null;
    }

    @Override
    public void openDoor() {

    }
}
