package com.cre8ivec.ericj.dungeonhero.utility.Rooms;

public class CaveRoom extends IRoom {

    public CaveRoom(String name) {
        this.name = name;
    }

    @Override
    public IRoom getNewRoom(String name) {
        return new CaveRoom(name);
    }
}
