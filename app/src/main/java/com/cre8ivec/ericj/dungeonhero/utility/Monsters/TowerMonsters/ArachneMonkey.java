package com.cre8ivec.ericj.dungeonhero.utility.Monsters.TowerMonsters;

import com.cre8ivec.ericj.dungeonhero.utility.ElementType;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;

public class ArachneMonkey extends IMonster {
    public ArachneMonkey(Integer level) {
        name = "Arachne Monkey";
        this.level = level;
        monsterType = ElementType.None;
        health = MED_ENEMY_HEALTH * level;
        attackPwr = MED_ENEMY_ATTACK * level;
    }
}
