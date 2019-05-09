package com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors;

import com.cre8ivec.ericj.dungeonhero.utility.Items.IItem;

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

    @Override
    public Boolean uses(IItem item) {
        return false;
    }
}
