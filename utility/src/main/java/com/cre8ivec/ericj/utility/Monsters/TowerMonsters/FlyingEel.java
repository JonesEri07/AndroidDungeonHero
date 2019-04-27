package com.cre8ivec.ericj.utility.Monsters.TowerMonsters;

import com.cre8ivec.ericj.utility.ElementType;
import com.cre8ivec.ericj.utility.Monsters.IMonster;

public class FlyingEel extends IMonster {
    public FlyingEel(Integer level) {
        name = "Flying Eel";
        this.level = level;
        monsterType = ElementType.Basic;
        health = LOW_ENEMY_HEALTH * level;
        attack = LOW_ENEMY_ATTACK * level;
    }
}
