package com.cre8ivec.ericj.utility.Monsters.TowerMonsters;

import com.cre8ivec.ericj.utility.ElementType;
import com.cre8ivec.ericj.utility.Monsters.IMonster;

public class RabidMonk extends IMonster {
    public RabidMonk(Integer level) {
        name = "Rabid Monk";
        this.level = level;
        monsterType = ElementType.Basic;
        health = HIGH_ENEMY_HEALTH * level;
        attack = HIGH_ENEMY_ATTACK * level;
    }
}
