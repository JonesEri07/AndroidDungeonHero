package com.cre8ivec.ericj.dungeonhero.utility.DungeonFactory;

import com.cre8ivec.ericj.dungeonhero.utility.Items.Apple;
import com.cre8ivec.ericj.dungeonhero.utility.Items.Coin;
import com.cre8ivec.ericj.dungeonhero.utility.Items.Key;
import com.cre8ivec.ericj.dungeonhero.utility.Items.Rope;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.CaveMonsters.EarthSlug;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.CaveMonsters.Goblin;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.CaveMonsters.NakedMoleBat;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.CaveMonsters.Troll;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.TowerMonsters.RabidMonk;
import com.cre8ivec.ericj.dungeonhero.utility.Rooms.CaveRoom;
import com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors.LockedDoor;
import com.cre8ivec.ericj.dungeonhero.utility.Rooms.Doors.SecretDoor;
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
        CaveRoom r_10 = (CaveRoom) currentRoom.addNorthRoom("r_10", new LockedDoor(new Key()));
        CaveRoom r_01 = (CaveRoom) currentRoom.addEastRoom("r_01", new UnlockedDoor());
        CaveRoom r_0n1 = (CaveRoom) currentRoom.addWestRoom("r_0n1", new LockedDoor(new Rope()));

        // r_01
        CaveRoom r_02 = (CaveRoom) r_01.addEastRoom("r_02", new UnlockedDoor());
        r_01.addItem(new Apple());
        r_01.addMonster(new NakedMoleBat(3));

        // r_02
        CaveRoom r_12 = (CaveRoom) r_02.addNorthRoom("r_12", new SecretDoor(new Apple()));
        r_02.addItem(new Rope());
        r_02.addMonster(new NakedMoleBat(1));


        // r_0n1
        r_0n1.addItem(new Key());
        r_0n1.addMonster(new EarthSlug(3));

        // r_10
        CaveRoom r_1n1 = (CaveRoom) r_10.addWestRoom("use coin", new UnlockedDoor());
        CaveRoom r_11 = (CaveRoom) r_10.addEastRoom("r_11", new UnlockedDoor());

        // r_1n1
        CaveRoom r_2n1 = (CaveRoom) r_1n1.addNorthRoom("secret Key Room", new SecretDoor(new Coin()));

        // r_2n1
        r_2n1.addItem(new Key());

        // r_11
        r_11.addEastRoom(r_12, new UnlockedDoor());
        r_11.addItem(new Coin());

        // r_12
        CaveRoom r_22 = (CaveRoom) r_12.addNorthRoom("r_22", new LockedDoor(new Key()));

        // r_22
        CaveRoom r23 = (CaveRoom) r_22.addEastRoom("r_23", new UnlockedDoor());
        CaveRoom r32 = (CaveRoom) r_22.addNorthRoom("r_32", new UnlockedDoor());
        r_22.addMonster(new Goblin(1));

        // r23
        r23.addItem(new Sword());

        // r32
        r32.addMonster(new Troll(1));

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
