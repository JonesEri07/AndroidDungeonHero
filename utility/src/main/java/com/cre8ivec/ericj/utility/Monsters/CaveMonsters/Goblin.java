package com.cre8ivec.ericj.utility.Monsters.CaveMonsters;

import com.cre8ivec.ericj.utility.ElementType;
import com.cre8ivec.ericj.utility.Monsters.IMonster;

public class Goblin extends IMonster {
    public Goblin(Integer level) {
        name = "Goblin";
        this.level = level;
        monsterType = ElementType.Basic;
        health = MED_ENEMY_HEALTH * level;
        attack = MED_ENEMY_ATTACK * level;
    }
}
