package com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors;

import com.cre8ivec.ericj.dungeonhero.utility.Items.IItem;

public abstract class IDoor {

    Boolean visibility;

    Boolean openable;

    public abstract Boolean isVisible();

    public abstract Boolean canOpen();

    public abstract IDoor returnDoor();

    public abstract void openDoor();

    public abstract Boolean uses(IItem item);
}
