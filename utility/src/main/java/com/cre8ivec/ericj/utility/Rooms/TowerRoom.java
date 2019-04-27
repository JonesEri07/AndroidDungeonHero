package com.cre8ivec.ericj.utility.Rooms;

public class TowerRoom extends IRoom {

    public TowerRoom(String name) {
        this.name = name;
    }

    @Override
    public IRoom getNewRoom(String name) {
        return new TowerRoom(name);
    }
}
