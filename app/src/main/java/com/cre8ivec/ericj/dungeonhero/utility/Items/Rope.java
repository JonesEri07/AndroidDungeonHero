package com.cre8ivec.ericj.dungeonhero.utility.Items;

import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;

public class Rope extends IItem {
    @Override
    public void useOnHero(IHero hero) {

    }

    public Rope() {
        name = "Rope";
        resource = R.drawable.rope;
        useOnHero = null;
    }
}
