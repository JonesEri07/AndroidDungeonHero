package com.cre8ivec.ericj.dungeonhero.utility.Rooms;

import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;
import com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors.IDoor;

public abstract class IRoom {

    private IRoom north;
    private IRoom east;
    private IRoom south;
    private IRoom west;
    private IRoom up;
    private IRoom down;

    private IDoor northDoor;
    private IDoor eastDoor;
    private IDoor southDoor;
    private IDoor westDoor;
    private IDoor upDoor;
    private IDoor downDoor;

    protected String name;
    private Object item;
    private IMonster monster;

    public String getName() {
        return name;
    }

    public abstract IRoom getNewRoom(String name);

    public IRoom addNorthRoom(String name, IDoor door) {
        IRoom newIRoom = getNewRoom(name);
        addNorthRoom(newIRoom, door);
        return newIRoom;
    }

    public IRoom addEastRoom(String name, IDoor door) {
        IRoom newIRoom = getNewRoom(name);
        addEastRoom(newIRoom, door);
        return newIRoom;
    }

    public IRoom addSouthRoom(String name, IDoor door) {
        IRoom newIRoom = getNewRoom(name);
        addSouthRoom(newIRoom, door);
        return newIRoom;
    }

    public IRoom addWestRoom(String name, IDoor door) {
        IRoom newIRoom = getNewRoom(name);
        addWestRoom(newIRoom, door);
        return newIRoom;
    }

    public IRoom addUpRoom(String name, IDoor door) {
        IRoom newIRoom = getNewRoom(name);
        addUpRoom(newIRoom, door);
        return newIRoom;
    }

    public IRoom addDownRoom(String name, IDoor door) {
        IRoom newIRoom = getNewRoom(name);
        addDownRoom(newIRoom, door);
        return newIRoom;
    }


    public void addNorthRoom(IRoom newIRoom, IDoor door) {
        IDoor newDoor;
        if ((newDoor = door.returnDoor()) != null)
            newIRoom.setSouthRoom(this, newDoor);
        setNorthRoom(newIRoom, door);
    }

    public void addEastRoom(IRoom newIRoom, IDoor door) {
        IDoor newDoor;
        if (( newDoor = door.returnDoor()) != null)
            newIRoom.setWestRoom(this, newDoor);
        setEastRoom(newIRoom, door);
    }

    public void addSouthRoom(IRoom newIRoom, IDoor door) {
        IDoor newDoor;
        if (( newDoor = door.returnDoor()) != null)
            newIRoom.setNorthRoom(this, newDoor);
        setSouthRoom(newIRoom, door);
    }

    public void addWestRoom(IRoom newIRoom, IDoor door) {
        IDoor newDoor;
        if (( newDoor = door.returnDoor()) != null)
            newIRoom.setEastRoom(this, newDoor);
        setWestRoom(newIRoom, door);
    }

    public void addUpRoom(IRoom newIRoom, IDoor door) {
        IDoor newDoor;
        if (( newDoor = door.returnDoor()) != null)
            newIRoom.setDownRoom(this, newDoor);
        setUpRoom(newIRoom, door);
    }

    public void addDownRoom(IRoom newIRoom, IDoor door) {
        IDoor newDoor;
        if (( newDoor = door.returnDoor()) != null)
            newIRoom.setUpRoom(this, newDoor);
        setDownRoom(newIRoom, door);
    }

    private void setNorthRoom(IRoom IRoom, IDoor door) { northDoor = door; north = IRoom; }

    private void setEastRoom(IRoom IRoom, IDoor door) { eastDoor = door; east = IRoom; }

    private void setSouthRoom(IRoom IRoom, IDoor door) { southDoor = door; south = IRoom; }

    private void setWestRoom(IRoom IRoom, IDoor door) { westDoor = door; west = IRoom; }

    private void setUpRoom(IRoom room, IDoor door) { upDoor = door; up = room; }

    private void setDownRoom(IRoom room, IDoor door) { downDoor = door; down = room; }


    // DESIGN FLAW: Should be same door, should not have to open two doors that should be one.
    public IRoom getNorth() {
        northDoor.openDoor();
        north.getSouthDoor().openDoor();
        return north; }

    public IRoom getEast() {
        eastDoor.openDoor();
        east.getWestDoor().openDoor();
        return east; }

    public IRoom getSouth() {
        southDoor.openDoor();
        south.getNorthDoor().openDoor();
        return south; }

    public IRoom getWest() {
        westDoor.openDoor();
        west.getEastDoor().openDoor();
        return west; }

    public IRoom getUp() {
        upDoor.openDoor();
        up.getDownDoor().openDoor();
        return up; }

    public IRoom getDown() {
        downDoor.openDoor();
        down.getUpDoor().openDoor();
        return down; }

    public IDoor getNorthDoor() {
        return northDoor;
    }

    public IDoor getEastDoor() {
        return eastDoor;
    }

    public IDoor getSouthDoor() {
        return southDoor;
    }

    public IDoor getWestDoor() {
        return westDoor;
    }

    public IDoor getUpDoor() {
        return upDoor;
    }

    public IDoor getDownDoor() {
        return downDoor;
    }

    public Boolean hasDoorToNorth() {
        if (northDoor == null)
            return false;
        return northDoor.isVisible();
    }

    public Boolean hasDoorToEast() {
        if (eastDoor == null)
            return false;
        return eastDoor.isVisible();
    }

    public Boolean hasDoorToSouth() {
        if (southDoor == null)
            return false;
        return southDoor.isVisible();
    }

    public Boolean hasDoorToWest() {
        if (westDoor == null)
            return false;
        return westDoor.isVisible();
    }

    public Boolean hasDoorToUp() {
        if (upDoor == null)
            return false;
        return upDoor.isVisible();
    }

    public Boolean hasDoorToDown() {
        if (downDoor == null)
            return false;
        return downDoor.isVisible();
    }


    public Boolean canOpenNorth() {
        return northDoor.canOpen();
    }

    public Boolean canOpenEast() {
        return eastDoor.canOpen();
    }

    public Boolean canOpenSouth() {
        return southDoor.canOpen();
    }

    public Boolean canOpenWest() {
        return westDoor.canOpen();
    }

    public Boolean canOpenUp() {
        return upDoor.canOpen();
    }

    public Boolean canOpenDown() {
        return downDoor.canOpen();
    }

    // Monster methods
    public void addMonster(IMonster monster) {
        this.monster = monster;
    }

    public IMonster getMonster() {
        IMonster mon = monster;
        monster = null;
        return mon;
    }

    // Item methods
    public void addItem(Object item) { this.item = item; }

    public Object getItem() {
        Object i = item;
        item = null;
        return i;
    }
}


// Maybe have doors and rooms With hidden/secret doors!