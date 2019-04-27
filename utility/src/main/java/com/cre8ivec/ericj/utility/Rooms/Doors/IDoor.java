package com.cre8ivec.ericj.utility.Rooms.Doors;

public abstract class IDoor {

    Boolean visibility;

    Boolean openable;

    public abstract Boolean isVisible();

    public abstract Boolean canOpen();

    public abstract IDoor returnDoor();

    public abstract void openDoor();
}
