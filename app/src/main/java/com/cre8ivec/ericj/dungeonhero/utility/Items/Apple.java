package com.cre8ivec.ericj.dungeonhero.utility.Items;

import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;

public class Apple extends IItem {
    public Apple() {
        name = "Apple";
        resource = R.drawable.apple;
        useOnHero = "Eat";
    }

    @Override
    public void useOnHero(IHero hero) {

    }
}
