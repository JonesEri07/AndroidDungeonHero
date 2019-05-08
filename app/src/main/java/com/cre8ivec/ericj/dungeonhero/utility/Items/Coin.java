package com.cre8ivec.ericj.dungeonhero.utility.Items;

import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;

public class Coin extends IItem {

    public Coin() {
        name = "Coin";
        resource = R.drawable.coin;
        usableOnHero = false;
    }

    @Override
    public void useOnHero(IHero hero) {

    }
}
