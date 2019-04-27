package com.cre8ivec.ericj.utility.Heros;

import com.cre8ivec.ericj.utility.Weapons.Fists;

import java.util.ArrayList;
import java.util.HashMap;

public class Hero extends IHero{

    public Hero() {
        name = "Hero";
        items = new HashMap<>();
        inventory = new ArrayList<>();
        equipedWeapon = new Fists();
    }

}
