package com.cre8ivec.ericj.dungeonhero.utility.Rooms;

public class UnderWaterRoom extends IRoom {

    public UnderWaterRoom(String name) {
        this.name = name;
    }

    @Override
    public IRoom getNewRoom(String name) {
        return new UnderWaterRoom(name);
    }
}
