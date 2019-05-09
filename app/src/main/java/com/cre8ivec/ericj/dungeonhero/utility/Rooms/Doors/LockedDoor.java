package com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors;

import com.cre8ivec.ericj.dungeonhero.utility.Items.IItem;

public class LockedDoor extends IDoor {

    private IItem itemNeeded;
    private IDoor return_door;

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
        return_door = new LockedDoor(itemNeeded);
        return return_door;
    }

    @Override
    public void openDoor() {
        // Turn other door to normal door
        return_door = new UnlockedDoor();
        openable = true;

    }

    @Override
    public Boolean uses(IItem item) {
        if (!openable && item.getName().equalsIgnoreCase(itemNeeded.getName())) {
            openDoor();
            return true;
        }
        return false;
    }


}
