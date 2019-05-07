package com.cre8ivec.ericj.dungeonhero.utility.Monsters.CaveMonsters;

import com.cre8ivec.ericj.dungeonhero.utility.ElementType;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;

public class NakedMoleBat extends IMonster {
    public NakedMoleBat(Integer level) {
        name = "Naked Mole Bat";
        this.level = level;
        monsterType = ElementType.Basic;
        health = LOW_ENEMY_HEALTH * level;
        attack = LOW_ENEMY_ATTACK * level;
    }
}
