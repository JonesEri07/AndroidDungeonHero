package com.cre8ivec.ericj.dungeonhero.utility.Items;

import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.Heros.IHero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Apple extends IItem {
    public Apple() {
        name = "Apple";
        resource = R.drawable.apple;
        useOnHero = "Eat";
    }

    @Override
    public void useOnHero(IHero hero) {
        hero.heal(5);

    }
}
