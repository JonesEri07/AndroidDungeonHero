package com.cre8ivec.ericj.dungeonhero.utility.Monsters.CaveMonsters;

import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.ElementType;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;

public class NakedMoleBat extends IMonster {
    public NakedMoleBat(Integer level) {
        name = "Naked Mole Bat";
        this.level = level;
        monsterType = ElementType.None;
        health = LOW_ENEMY_HEALTH * level;
        attackPwr = LOW_ENEMY_ATTACK * level;
        resource = R.drawable.nake_mole_bat;
    }
}
