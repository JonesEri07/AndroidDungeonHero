package com.cre8ivec.ericj.utility.DungeonFactory;

import com.cre8ivec.ericj.utility.Items.IItem;
import com.cre8ivec.ericj.utility.Rooms.IRoom;

public abstract class IDungeon {

    IRoom currentRoom;
    protected IRoom exitOpenRoom;
    IRoom prevRoom;

    Boolean upDownEnabled;

    public abstract void buildDungeon();

    public abstract String description();

    public abstract String toString();

     public void goNorth() {
         prevRoom = currentRoom;
         currentRoom = currentRoom.getNorth(); }

    public void goEast() {
         prevRoom = currentRoom;
         currentRoom = currentRoom.getEast();
    }

    public void goSouth() {
         prevRoom = currentRoom;
        currentRoom = currentRoom.getSouth();
    }

    public void goWest() {
        prevRoom = currentRoom;
        currentRoom = currentRoom.getWest();
    }

    public void goUp() {
        prevRoom = currentRoom;
        currentRoom = currentRoom.getUp();
    }

    public void goDown() {
        prevRoom = currentRoom;
        currentRoom = currentRoom.getDown();
    }

    public void changeWeapon() {

    }

    public void searchPushed() {

    }

    public void useItemPushed() {

    }

    public void keepItem(IItem item) {

    }

    public IRoom getCurrentRoom() { return currentRoom; }

    public Boolean getUpDownEnabled() { return upDownEnabled; }

    public Object getItemInCurrentRoom() { return currentRoom.getItem(); }

}
