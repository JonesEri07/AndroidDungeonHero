package com.cre8ivec.ericj.dungeonhero.utility.Monsters.TowerMonsters;

import com.cre8ivec.ericj.dungeonhero.utility.ElementType;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;

public class RabidMonk extends IMonster {
    public RabidMonk(Integer level) {
        name = "Rabid Monk";
        this.level = level;
        monsterType = ElementType.None;
        health = HIGH_ENEMY_HEALTH * level;
        attackPwr = HIGH_ENEMY_ATTACK * level;
    }
}
