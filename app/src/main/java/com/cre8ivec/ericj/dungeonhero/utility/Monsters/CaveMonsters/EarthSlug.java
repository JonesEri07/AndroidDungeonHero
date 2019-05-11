package com.cre8ivec.ericj.dungeonhero.utility.Monsters.CaveMonsters;

import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.ElementType;
import com.cre8ivec.ericj.dungeonhero.utility.Monsters.IMonster;

public class EarthSlug extends IMonster {

    public EarthSlug(Integer level) {
        name = "Earth Slug";
        this.level = level;
        monsterType = ElementType.None;
        health = LOW_ENEMY_HEALTH * level;
        attackPwr = LOW_ENEMY_ATTACK * level;
        resource = R.drawable.earth_worm;
    }

}
