package com.cre8ivec.ericj.dungeonhero.utility.Monsters.TowerMonsters;

import com.cre8ivec.ericj.dungeonhero.utility.ElementType;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;

public class FlyingEel extends IMonster {
    public FlyingEel(Integer level) {
        name = "Flying Eel";
        this.level = level;
        monsterType = ElementType.Basic;
        health = LOW_ENEMY_HEALTH * level;
        attackPwr = LOW_ENEMY_ATTACK * level;
    }
}
