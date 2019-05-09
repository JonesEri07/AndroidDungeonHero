package com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors;

import com.cre8ivec.ericj.dungeonhero.utility.Items.IItem;

public class SecretDoor extends IDoor {

    private IItem itemNeeded;

    public SecretDoor(IItem itemNeeded) {
        visibility = false;
        openable = false;
        this.itemNeeded = itemNeeded;
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

    @Override
    public Boolean uses(IItem item) {
        if (!openable && item.getName().equalsIgnoreCase(itemNeeded.getName())) {
            openDoor();
            return true;
        }
        return false;
    }
}
