package com.cre8ivec.ericj.dungeonhero.utility.DungeonFactory;

import com.cre8ivec.ericj.dungeonhero.utility.Items.Apple;
import com.cre8ivec.ericj.dungeonhero.utility.Items.Coin;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.CaveMonsters.NakedMoleBat;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.TowerMonsters.RabidMonk;
import com.cre8ivec.ericj.dungeonhero.utility.Rooms.CaveRoom;
import com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors.LockedDoor;
import com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors.UnlockedDoor;
import com.cre8ivec.ericj.dungeonhero.utility.Weapons.Sword;

class CaveDungeon extends IDungeon {

    public CaveDungeon() {
        currentRoom = new CaveRoom("Start");
        upDownEnabled = false;
    }

    @Override
    public void buildDungeon() {
        // Start
        CaveRoom r_10 = (CaveRoom) currentRoom.addNorthRoom("r_10", new LockedDoor(new Apple()));
        CaveRoom r_01 = (CaveRoom) currentRoom.addEastRoom("r_01", new UnlockedDoor());

        // r_10
        CaveRoom r_11 = (CaveRoom) r_10.addEastRoom("r_11", new UnlockedDoor());
        r_10.addMonster(new NakedMoleBat(1));
        r_10.addItem(new Coin());

        // r_01
        r_01.addNorthRoom(r_11, new UnlockedDoor());
        r_01.addItem(new Apple());


        // r_11
        r_11.addMonster(new RabidMonk(1));
        r_11.addItem(new Sword());


//        OpenRoom r_0n1 = startRoom.addWestRoom("r_0n1");
//
//        OpenRoom r_20 = r_10.addNorthRoom("r_20");
//        OpenRoom r_11 = r_10.addEastRoom("r_11");
//
//        OpenRoom r_30 = r_20.addNorthRoom("r_30");


    }

    @Override
    public String description() {
        return "A cave not of wonders, but of danger and glory.\nWelcome, to the CAVE!";
    }

    @Override
    public String toString() {
        return "Cave Dungeon";
    }


}
