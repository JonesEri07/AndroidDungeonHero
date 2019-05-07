package com.cre8ivec.ericj.dungeonhero.utility.DungeonFactory;

import com.cre8ivec.ericj.dungeonhero.utility.Monsters.TowerMonsters.ArachneMonkey;
import com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors.SecretDoor;
import com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors.UnlockedDoor;
import com.cre8ivec.ericj.dungeonhero.utility.Rooms.TowerRoom;

class TowerDungeon extends IDungeon {

    public TowerDungeon() {
        currentRoom = new TowerRoom("Start");
        upDownEnabled = true;
    }

    @Override
    public void buildDungeon() {
        TowerRoom r_10 = (TowerRoom) currentRoom.addNorthRoom("r_10", new SecretDoor());
        TowerRoom r_01 = (TowerRoom) currentRoom.addEastRoom("r_01", new UnlockedDoor());

        // r_10
        TowerRoom r_11 = (TowerRoom) r_10.addEastRoom("r_11", new UnlockedDoor());
        r_10.addMonster(new ArachneMonkey(1));

        // r_01
        r_01.addNorthRoom(r_11, new UnlockedDoor());

    }

    @Override
    public String description() {
        return "Leering before you, the eerie tower of Gribvash!";
    }

    @Override
    public String toString() {
        return "Tower Dungeon";
    }

}
