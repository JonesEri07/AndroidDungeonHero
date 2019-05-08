package com.cre8ivec.ericj.dungeonhero.utility.Items;

import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;

public class HealthPotion extends IItem {

    public HealthPotion() {
        name = "Health Potion";
        //resource = R.drawable
        usableOnHero = true;
    }

    @Override
    public void useOnHero(IHero hero) {

    }
}
