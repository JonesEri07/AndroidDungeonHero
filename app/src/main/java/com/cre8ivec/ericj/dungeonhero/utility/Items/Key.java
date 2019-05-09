package com.cre8ivec.ericj.dungeonhero.utility.Items;

import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;

public class Key extends IItem {
    public Key() {
        name = "Key";
        resource = R.drawable.key;
        useOnHero = null;
    }

    @Override
    public void useOnHero(IHero hero) {

    }
}
