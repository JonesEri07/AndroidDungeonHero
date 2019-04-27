package com.cre8ivec.ericj.utility.Monsters.CaveMonsters;

import com.cre8ivec.ericj.utility.ElementType;
import com.cre8ivec.ericj.utility.Monsters.IMonster;

public class NakedMoleBat extends IMonster {
    public NakedMoleBat(Integer level) {
        name = "Naked Mole Bat";
        this.level = level;
        monsterType = ElementType.Basic;
        health = LOW_ENEMY_HEALTH * level;
        attack = LOW_ENEMY_ATTACK * level;
    }
}
