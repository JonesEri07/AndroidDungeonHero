package com.cre8ivec.ericj.dungeonhero.utility.Monsters.CaveMonsters;

import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.ElementType;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;

public class Troll extends IMonster {
    public Troll(Integer level) {
        name = "Troll";
        this.level = level;
        monsterType = ElementType.None;
        health = HIGH_ENEMY_HEALTH * level;
        attackPwr = HIGH_ENEMY_ATTACK * level;
        resource = R.drawable.troll;
    }
}
