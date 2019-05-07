package com.cre8ivec.ericj.dungeonhero.utility.DungeonFactory;

public class GetDungeonFactory {

    public IDungeon getDungeon(String type) {
        if (type == null)
            return null;
        if (type.equalsIgnoreCase("CAVE"))
            return new CaveDungeon();
        if (type.equalsIgnoreCase("TOWER"))
            return new TowerDungeon();
        if (type.equalsIgnoreCase("UNDERWATER"))
            return new UnderWaterDungeon();
        return null;
    }
}
