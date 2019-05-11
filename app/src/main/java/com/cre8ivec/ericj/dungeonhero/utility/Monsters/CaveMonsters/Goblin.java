package com.cre8ivec.ericj.dungeonhero.utility.Monsters.CaveMonsters;

import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.ElementType;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;

public class Goblin extends IMonster {
    public Goblin(Integer level) {
        name = "Goblin";
        this.level = level;
        monsterType = ElementType.None;
        health = MED_ENEMY_HEALTH * level;
        attackPwr = MED_ENEMY_ATTACK * level;
        resource = R.drawable.goblin;
    }
}
