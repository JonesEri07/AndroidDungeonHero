package com.cre8ivec.ericj.dungeonhero.utility.Items;

import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;

public class ManaPotion extends IItem {

    public ManaPotion() {
        name = "Mana Potion";
        //resource = R.drawable
        useOnHero = "Drink";
    }

    @Override
    public void useOnHero(IHero hero) {

    }
}
