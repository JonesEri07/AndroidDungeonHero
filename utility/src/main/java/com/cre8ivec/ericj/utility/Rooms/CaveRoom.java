package com.cre8ivec.ericj.utility.Rooms;

public class CaveRoom extends IRoom {

    public CaveRoom(String name) {
        this.name = name;
    }

    @Override
    public IRoom getNewRoom(String name) {
        return new CaveRoom(name);
    }
}
