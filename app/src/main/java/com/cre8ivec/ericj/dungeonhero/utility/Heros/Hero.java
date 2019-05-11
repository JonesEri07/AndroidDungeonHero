package com.cre8ivec.ericj.dungeonhero.utility.Heros;

import com.cre8ivec.ericj.dungeonhero.R;
import com.cre8ivec.ericj.dungeonhero.utility.Weapons.Fists;

import java.util.ArrayList;
import java.util.HashMap;

public class Hero extends IHero{

    public Hero() {
        name = "Hero";
        items = new HashMap<>();
        inventory = new ArrayList<>();
        equipedWeapon = new Fists();
        health = 50;
        maxHealth = 50;
        resource_back = R.drawable.warrior_back;
        resource_front = R.drawable.warrior;

    }

}
