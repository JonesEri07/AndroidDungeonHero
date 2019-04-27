package com.cre8ivec.ericj.utility.DungeonFactory;

import com.cre8ivec.ericj.utility.Rooms.UnderWaterRoom;

class UnderWaterDungeon extends IDungeon {
    @Override
    public void buildDungeon() {
        currentRoom = new UnderWaterRoom("Start");
        upDownEnabled = true;
    }

    @Override
    public String description() {
        return "The dungeon is sinking! Quick! Find an escape route before the building is completely submerged.";
    }

    @Override
    public String toString() {
        return "Under Water Dungeon";
    }

}
