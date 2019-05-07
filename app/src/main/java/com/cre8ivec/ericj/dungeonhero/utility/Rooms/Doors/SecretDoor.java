package com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors;

public class SecretDoor extends IDoor {

    public SecretDoor() {
        visibility = false;
        openable = false;
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
        return new UnlockedDoor();
    }

    @Override
    public void openDoor() {
        visibility = true;
        openable = true;
    }
}
