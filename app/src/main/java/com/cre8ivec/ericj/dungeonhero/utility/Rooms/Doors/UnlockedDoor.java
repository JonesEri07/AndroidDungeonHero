package com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors;

public class UnlockedDoor extends IDoor {
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
        return new UnlockedDoor();
    }

    @Override
    public void openDoor() {

    }
}
