package com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors;

import com.cre8ivec.ericj.dungeonhero.utility.Items.IItem;

public class LockedDoor extends IDoor {

    private IItem itemNeeded;

    public LockedDoor(IItem neededItem) {
        visibility = true;
        openable = false;
        this.itemNeeded = neededItem;
    }

    public IItem getItemNeeded() {
        return itemNeeded;
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
        return new LockedDoor(this.getItemNeeded());
    }

    @Override
    public void openDoor() {

    }


}
