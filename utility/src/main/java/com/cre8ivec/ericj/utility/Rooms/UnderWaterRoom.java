package com.cre8ivec.ericj.utility.Rooms;

public class UnderWaterRoom extends IRoom {

    public UnderWaterRoom(String name) {
        this.name = name;
    }

    @Override
    public IRoom getNewRoom(String name) {
        return new UnderWaterRoom(name);
    }
}
