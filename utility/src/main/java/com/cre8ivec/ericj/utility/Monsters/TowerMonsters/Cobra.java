package com.cre8ivec.ericj.utility.Monsters.TowerMonsters;

import com.cre8ivec.ericj.utility.ElementType;
import com.cre8ivec.ericj.utility.Monsters.IMonster;

public class Cobra extends IMonster {
    public Cobra(Integer level) {
        name = "Cobra";
        this.level = level;
        monsterType = ElementType.Basic;
        health = LOW_ENEMY_HEALTH * level;
        attack = LOW_ENEMY_ATTACK * level;
    }
}
