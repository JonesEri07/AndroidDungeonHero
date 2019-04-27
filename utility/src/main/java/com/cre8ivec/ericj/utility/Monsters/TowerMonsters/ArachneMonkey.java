package com.cre8ivec.ericj.utility.Monsters.TowerMonsters;

import com.cre8ivec.ericj.utility.ElementType;
import com.cre8ivec.ericj.utility.Monsters.IMonster;

public class ArachneMonkey extends IMonster {
    public ArachneMonkey(Integer level) {
        name = "Arachne Monkey";
        this.level = level;
        monsterType = ElementType.Basic;
        health = MED_ENEMY_HEALTH * level;
        attack = MED_ENEMY_ATTACK * level;
    }
}
