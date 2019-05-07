package com.cre8ivec.ericj.dungeonhero.utility.Monsters.CaveMonsters;

import com.cre8ivec.ericj.dungeonhero.utility.ElementType;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;

public class Goblin extends IMonster {
    public Goblin(Integer level) {
        name = "Goblin";
        this.level = level;
        monsterType = ElementType.Basic;
        health = MED_ENEMY_HEALTH * level;
        attack = MED_ENEMY_ATTACK * level;
    }
}
