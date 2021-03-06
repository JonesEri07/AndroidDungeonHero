package com.cre8ivec.ericj.dungeonhero.utility.Monsters.TowerMonsters;

import com.cre8ivec.ericj.dungeonhero.utility.ElementType;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;

public class Cobra extends IMonster {
    public Cobra(Integer level) {
        name = "Cobra";
        this.level = level;
        monsterType = ElementType.None;
        health = LOW_ENEMY_HEALTH * level;
        attackPwr = LOW_ENEMY_ATTACK * level;
    }
}
